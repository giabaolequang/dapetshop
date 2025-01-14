package com.example.da_ltdd_petshop.ui.theme.navigation
// Định nghĩa các màn hình (route)
sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")
    object CartDetailsScreen : Screen(route = "cartdetails_screen")
    object ContactScreen : Screen(route = "contact_screen")
    object CustomerSupportScreen : Screen(route = "customersupport_screen")
    object EditPersonalInformationScreen : Screen(route = "editpersonalinformation_screen")
    object ForgetPasswordScreen : Screen(route = "forgetpassword_screen")
    object HomeScreen : Screen(route = "home_screen")
    object InformationAndWarrantyPolicyScreen : Screen(route = "informationandwarrantypolicy_screen")
    object OrderStatusScreen : Screen(route = "orderstatus_screen")
    object PaymentStatusScreen : Screen(route = "paymentstatus_screen")
    object ProductDetailsScreen : Screen(route = "productdetails_screen")
    object RegisterScreen : Screen(route = "register_screen")
    object ResetPasswordScreen : Screen(route = "resetpassword_screen")
    object ScoreScreen : Screen(route = "score_screen")
    object SettingScreen : Screen(route = "setting_screen")
    object TransactionHistoryScreen : Screen(route = "transactionhistory_screen")
}

