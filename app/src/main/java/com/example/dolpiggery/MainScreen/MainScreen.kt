package com.example.dolpiggery.MainScreen

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.compose.rememberNavController
import com.example.dolpiggery.MainScreen.NavGraph.AppNavGraph
import com.example.dolpiggery.MainScreen.UIComponents.NavigationBar.CreateNavBar
import com.example.dolpiggery.R
import com.example.dolpiggery.ui.theme.DolPiggeryTheme
import com.example.dolpiggery.ui.theme.PacificCyan5
import com.example.dolpiggery.ui.theme.Snow60
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainScreen : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DolPiggeryTheme {
                val navController = rememberNavController()

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "Doldolpiggery",
                                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                )
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = PacificCyan5
                            ),
                        )
                    },
                    containerColor = Snow60,
                    modifier = Modifier
                        .fillMaxSize(),
                    bottomBar = {
                        CreateNavBar(navController = navController)
                    }
                ) { innerPadding ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        AppNavGraph(navController = navController)
//                        DisplayText()
                    }
                }
            }
        }
    }
}
@Composable
fun DisplayText() {
    var dat by remember {
        mutableStateOf("hello")
    }

    val firebaseDatabse = FirebaseDatabase.getInstance().getReference().child("MAX30102")

    firebaseDatabse.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            if (snapshot.exists()) {
                Log.i("Hey", "Exists")
                dat = snapshot.value.toString()
            } else {
                Log.i("Hey", "Does not exist")
            }
            Log.i("Hey", "execute anyway")
        }

        override fun onCancelled(error: DatabaseError) {
            Log.i("Information", "Database Error: $error")
        }
    })

    Text(text = dat)
}