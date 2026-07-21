package com.example.zepto.presentation.drawer.address.addressScreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.zepto.R
import com.example.zepto.di.Address
import com.example.zepto.presentation.drawer.address.commpn.LocationSelectorChip
import com.example.zepto.presentation.drawer.address.viewmodel.AddressViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddressAddScreen(
        addressId: Int,
        navController: NavController,
        viewModel: AddressViewModel = hiltViewModel(),
        onAddressShowClick:()-> Unit,
        onBackClick: () -> Unit,
) {
    var fullName by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var addressLine1 by remember { mutableStateOf("") }
    var addressLine2 by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var pincode by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }
    var selectedLocation by remember { mutableStateOf("Home") }
    
  var titel = if (addressId == -1){
      "Add Address"
  } else {
      "Edit Address"
  }
    
    val font = FontFamily(Font(R.font.lexendexa_regular))
    
    val address by viewModel
            .getAddressById(id = addressId)
            .collectAsState(initial = null)
    
    LaunchedEffect(address){
        address?.let {
            fullName= it.fullName
            phoneNumber= it.phone
            addressLine1 = it.addressLine1
            addressLine2 = it.addressLine2
            city = it.city
            state = it.state
            country = it.country
            pincode = it.pincode
            selectedLocation = it.addressType
        }
    }
    
    
    Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                        modifier = Modifier.shadow(elevation = 5.dp),
                        title = {
                            Text(
                                    text = titel,
                                    color = Color.Black,
                                    fontSize = 18.sp,
                                    fontFamily = font,
                                    fontWeight = FontWeight.Bold
                            )
                        },
                        navigationIcon = {
                            IconButton(
                                    colors = IconButtonDefaults.iconButtonColors(
                                            containerColor = Color.Transparent,
                                            disabledContainerColor = Color.Transparent
                                    ),
                                    onClick = { onBackClick() }
                            ) {
                                Icon(
                                        imageVector = Icons.Filled.ArrowBack,
                                        contentDescription = null,
                                        modifier = Modifier.size(25.dp),
                                        tint = Color.Black
                                )
                            }
                        },
                )
            }
    ) { paddingValues ->
        LazyColumn(
                modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 20.dp)
                        .padding(paddingValues)
                        .imePadding(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                LocationSelectorChip(
                        selectedLocation =  selectedLocation,
                        onLocationSelected = {selectedLocation = it}
                )
                AddressDetailField(
                        label = "Full Name",
                        leadIcon = Icons.Outlined.Person,
                        placeholder = "Rahul Singh",
                        value = fullName,
                        onValueChange = { fullName = it }
                )
                
                AddressDetailField(
                        label = "Phone Number",
                        leadIcon = Icons.Filled.Phone,
                        placeholder = "9XXX-XXXX-X",
                        value = phoneNumber,
                        onValueChange = { phoneNumber = it }
                )
                
                AddressDetailField(
                        label = "Address Line 1",
                        leadIcon = Icons.Outlined.LocationOn,
                        placeholder = "Phase 1, Phase 2, and Laxmi Chowk areas of Hinjawad",
                        value = addressLine1,
                        onValueChange = { addressLine1 = it }
                )
                
                AddressDetailField(
                        label = "Address Line 2(Optional)",
                        leadIcon = Icons.Filled.Business,
                        placeholder = "Apartment, suite, unit, building, etc.",
                        value = addressLine2,
                        onValueChange = { addressLine2 = it }
                )
                LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier.height(230.dp),
                        userScrollEnabled = false
                ) {
                    item {
                        AddressDetailField(
                                label = "City",
                                leadIcon = null,
                                placeholder = "Enter city",
                                value = city,
                                onValueChange = { city = it }
                        )
                    }
                    item {
                        AddressDetailField(
                                label = "Pincode",
                                leadIcon = null,
                                placeholder = "6-digit pincode",
                                value = pincode,
                                onValueChange = { pincode = it }
                        )
                    }
                    item {
                        AddressDetailField(
                                label = "State",
                                leadIcon = null,
                                placeholder = "Enter state",
                                value = state,
                                onValueChange = { state = it }
                        )
                    }
                    item {
                        AddressDetailField(
                                label = "Country",
                                leadIcon = null,
                                placeholder = "Enter country",
                                value = country,
                                onValueChange = { country = it }
                        )
                    }
                }
                Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                ){
                    Button(
                            onClick = {
                                val address = Address(
                                        id = if (addressId==-1)0 else addressId,
                                        fullName = fullName,
                                        phone = phoneNumber,
                                        addressLine1 = addressLine1,
                                        addressLine2 = addressLine2,
                                        city = city,
                                        state = state,
                                        country = country,
                                        pincode = pincode,
                                        addressType = selectedLocation
                                )
                             if (addressId ==-1){
                                viewModel.addAddress(address = address)
                             }else {
                                 viewModel.updateAddress(address)
                             }
                                onAddressShowClick()
                                
                            },
                            shape = MaterialTheme.shapes.medium,
                            colors = ButtonDefaults.buttonColors(
                                    containerColor =  Color(0xFF9863F5)
                            )
                    ) {
                        Text(
                                modifier = Modifier.padding(horizontal = 40.dp, vertical = 5.dp),
                                text = titel,
                                fontFamily = font
                        )
                    }
                }
            }
        }
    }
}