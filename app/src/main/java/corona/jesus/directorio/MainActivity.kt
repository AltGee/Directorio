package corona.jesus.directorio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import corona.jesus.directorio.modelos.UsuarioRepositorio
import corona.jesus.directorio.viewmodels.UsuarioViewModel
import corona.jesus.directorio.viewmodels.UsuarioViewModelFactory
import corona.jesus.directorio.vistas.PrincipalScreen

class MainActivity : ComponentActivity() {
    private val viewModel: UsuarioViewModel by viewModels {
        UsuarioViewModelFactory(UsuarioRepositorio())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DirectorioTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding: PaddingValues ->
                    PrincipalScreen(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DirectorioTheme(content: @Composable () -> Unit) {
    MaterialTheme(content = content)
}
