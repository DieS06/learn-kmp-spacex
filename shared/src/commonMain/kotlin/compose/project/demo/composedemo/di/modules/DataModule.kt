package compose.project.demo.composedemo.di.modules

import org.koin.dsl.module
import compose.project.demo.composedemo.data.remote.iRemoteRocketLaunchesDataSource
import compose.project.demo.composedemo.data.remote.RemoteRocketLaunchesDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

val dataModule = module {
    single<iRemoteRocketLaunchesDataSource> { RemoteRocketLaunchesDataSource(get(), Dispatchers.IO) }
}