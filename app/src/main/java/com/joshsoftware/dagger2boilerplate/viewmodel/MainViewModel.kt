package com.joshsoftware.dagger2boilerplate.viewmodel

import androidx.lifecycle.ViewModel
import com.joshsoftware.dagger2boilerplate.repository.SampleRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(repository: SampleRepository): ViewModel() {
}