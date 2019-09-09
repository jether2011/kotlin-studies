package com.jetherrodrigues.application.config

import com.jetherrodrigues.application.Application
import com.jetherrodrigues.application.web.controller.LayerController
import com.jetherrodrigues.application.web.controller.UserController
import com.jetherrodrigues.application.web.routes.LayerRoutes
import com.jetherrodrigues.application.web.routes.UserRoutes
import com.jetherrodrigues.domain.login.LayerRepository
import com.jetherrodrigues.domain.login.LayerService
import com.jetherrodrigues.domain.login.UserRepository
import com.jetherrodrigues.domain.login.UserService
import com.jetherrodrigues.resource.LayerRepositoryImpl
import com.jetherrodrigues.resource.UserRepositoryImpl
import org.koin.dsl.module.module

val configModule = module {
    single { Application() }
}

val userModule = module {
    single { UserRoutes(get()) }
    single { UserController(get()) }
    single { UserService(get()) }
    single { UserRepositoryImpl() as UserRepository }
}

val layerModule = module {
    single { LayerRoutes(get()) }
    single { LayerController(get()) }
    single { LayerService(get()) }
    single { LayerRepositoryImpl() as LayerRepository }
}

val appModules = listOf(configModule, userModule, layerModule)