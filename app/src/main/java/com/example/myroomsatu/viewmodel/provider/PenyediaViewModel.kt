package com.example.myroomsatu.viewmodel.provider
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myroomsatu.ContainerApp
import com.example.myroomsatu.viewmodel.DetailViewModel
import com.example.myroomsatu.viewmodel.EditViewModel
import com.example.myroomsatu.viewmodel.EntryViewModel
import com.example.myroomsatu.viewmodel.HomeViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            HomeViewModel(
                aplikasi().container.repositoriSiswa
            )
        }

        initializer {
            DetailViewModel(
                savedStateHandle = this.createSavedStateHandle(),
                repositoriSiswa = aplikasi().container.repositoriSiswa
            )
        }

        initializer {
            EntryViewModel(
                aplikasi().container.repositoriSiswa
            )
        }

        initializer {
            EditViewModel(
                savedStateHandle = this.createSavedStateHandle(),
                repositoriSiswa = aplikasi().container.repositoriSiswa
            )
        }
    }
}
fun CreationExtras.aplikasi(): ContainerApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as ContainerApp)
