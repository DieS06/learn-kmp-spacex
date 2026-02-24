package compose.project.demo.composedemo.di.modules

import DriverFactory
import compose.project.demo.composedemo.data.local.AppDatabase
import compose.project.demo.composedemo.data.local.ILocalRocketLaunchesDataSource
import compose.project.demo.composedemo.data.local.LocalRocketLaunchesDataSource
import org.koin.dsl.module
import compose.project.demo.composedemo.data.remote.IRemoteRocketLaunchesDataSource
import compose.project.demo.composedemo.data.remote.RemoteRocketLaunchesDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

val dataModule = module {
    single<IRemoteRocketLaunchesDataSource> { RemoteRocketLaunchesDataSource(get(), Dispatchers.IO) }
    single { get<DriverFactory>().createDriver() }
    single { AppDatabase(get()) }
    single { get<AppDatabase>().appDatabaseQueries }
    single<ILocalRocketLaunchesDataSource> { LocalRocketLaunchesDataSource(get()) }
}