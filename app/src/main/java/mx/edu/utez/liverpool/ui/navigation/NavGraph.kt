package mx.edu.utez.liverpool.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mx.edu.utez.liverpool.ui.screens.DetallesProductoScreen
import mx.edu.utez.liverpool.ui.screens.InicioScreen
import mx.edu.utez.liverpool.ui.screens.ListaProductosScreen
import mx.edu.utez.liverpool.ui.viewModel.ProductoViewModel

sealed class Route(val path: String) {
    object Inicio : Route("menu")
    object Detalles : Route("detalles")
    object Lista : Route("lista")
}

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    productoViewModel: ProductoViewModel = viewModel()
) {
    NavHost(
        navController = navController,
        startDestination = Route.Inicio.path,
        modifier = modifier
    ) {
        composable(Route.Inicio.path) {
            InicioScreen(
                onNavigationToListado = { navController.navigate(Route.Lista.path) }
            )
        }

        composable(Route.Lista.path) {
            ListaProductosScreen(
                viewModel = productoViewModel,
                onProductoClick = { navController.navigate(Route.Detalles.path) },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(Route.Detalles.path) {
            DetallesProductoScreen(
                viewModel = productoViewModel,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}