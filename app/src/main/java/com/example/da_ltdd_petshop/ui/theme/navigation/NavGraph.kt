package com.example.da_ltdd_petshop

import CartDetailsScreen
import ContactScreen
import CustomerSupportScreen
import ForgetPasswordScreen
import HomeScreen
import LoginScreen
import ProductDetailsScreen
import RegisterScreen
import ResetPasswordScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ban_meo.ui.theme.EditPersonalInformationScreen
import com.example.ban_meo.ui.theme.InformationAndWarrantyPolicyScreen
import com.example.ban_meo.ui.theme.PaymentStatusScreen
import com.example.ban_meo.ui.theme.OrderStatusScreen
import com.example.ban_meo.ui.theme.ScoreScreen
import com.example.ban_meo.ui.theme.SettingScreen
import com.example.ban_meo.ui.theme.TransactionHistoryScreen
import com.example.da_ltdd_petshop.ui.theme.navigation.Screen



@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login_screen") {
        composable("login_screen") {
            LoginScreen(navController = navController)
        }
        composable("contact_screen") {
            ContactScreen(navController)
        }

        composable("customersupport_screen") {
            CustomerSupportScreen(navController)
        }
        composable("editpersonalinformation_screen") {
            EditPersonalInformationScreen(navController)
        }
        composable("forgetpassword_screen") {
            ForgetPasswordScreen(navController)
        }
        composable("home_screen") {
            HomeScreen(navController)
        }
        composable("informationandwarrantypolicy_screen") {
            InformationAndWarrantyPolicyScreen(navController)
        }
        composable("orderstatus_screen") {
            OrderStatusScreen(navController)
        }
        composable("paymentstatus_screen") {
            PaymentStatusScreen(navController)
        }

        composable("productdetails_screen") {
            ProductDetailsScreen(navController)
        }
        composable("register_screen") {
            RegisterScreen(navController)
        }
        composable("resetpassword_screen") {
            ResetPasswordScreen(navController)
        }
        composable("score_screen") {
            ScoreScreen(navController)
        }
        composable("setting_screen") {
            SettingScreen(navController)
        }
        composable("transactionhistory_screen") {
            TransactionHistoryScreen(navController)
        }

    }
}

