package com.Parthip.pixabay.imageList.data.repository

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.Parthip.pixabay.imageList.data.local.Image.ImageDatabase
import com.Parthip.pixabay.imageList.data.mappers.toImage
import com.Parthip.pixabay.imageList.data.remote.PixabayApi
import com.Parthip.pixabay.imageList.domain.model.Image
import com.Parthip.pixabay.imageList.domain.repository.ImageListRepository
import com.Parthip.pixabay.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject


class ImageListRepositoryImpl @Inject constructor(
    private val pixabayApi: PixabayApi,
    private val imageDatabase: ImageDatabase
) : ImageListRepository  {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getImageList(
        forceFetchFromRemote: Boolean,
        page: Int,
        perpage: Int
    ): Flow<Resource<List<Image>>> {
       return flow{
            emit(Resource.Loading(true))

           val localImageList = imageDatabase.imageDAO.getImageList()

           val shouldLoadLocalImages = localImageList.isNotEmpty() && !forceFetchFromRemote

           if ( shouldLoadLocalImages ){
               emit(Resource.Success(
                   data = localImageList.map { imageEntity ->
                       imageEntity.toImage()
                   }
               ))

               emit(Resource.Loading(false))
               return@flow
           }

           val imageListFromApi = try {
               pixabayApi.getImageList(perpage, page)
           } catch ( e: IOException) {
               e.printStackTrace()
               emit(Resource.Error(message = "Error loading images"))
               return@flow
           }catch ( e: HttpException) {
               e.printStackTrace()
               emit(Resource.Error(message = "Error loading images"))
               return@flow
           }catch ( e: Exception) {
               e.printStackTrace()
               emit(Resource.Error(message = "Error loading images"))
               return@flow
           }

           val imageEntities = imageListFromApi.hits.let {
               it.map { imageDTO -> imageDTO.toImage() }
           }

           imageDatabase.imageDAO.upsertImageList(imageEntities)

           emit(Resource.Success(
               imageEntities.map { it.toImage() }
           ))
           emit(Resource.Loading(false))

       }
    }

    override suspend fun getImage(id: Int): Flow<Resource<Image>> {
        return flow {
            emit(Resource.Loading(true))

            val imageEntity = imageDatabase.imageDAO.getImageById(id)

            if(imageEntity != null){
                emit(
                    Resource.Success(imageEntity.toImage())
                )

                emit(Resource.Loading(false))
                return@flow
            }

            emit(Resource.Error("Error no such image"))
            emit(Resource.Loading(false))
        }
    }
}