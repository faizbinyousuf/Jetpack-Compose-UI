package com.example.carrentalapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.carrentalapp.R
import com.example.carrentalapp.Screens
import com.example.carrentalapp.ui.components.CommonYellowButton

@Composable
fun CreateAccountScreen(navController: NavController) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(horizontal = 15.dp),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	      ) {
		Text(
			text = "Create Account",
			fontSize = 21.sp,
			fontWeight = FontWeight.Bold,
			modifier = Modifier.padding(bottom = 15.dp)
		    )
		CustomTextField(hint = "Enter your email", onChanged = {})
		
		CustomTextField(hint = "Enter your password", onChanged = {})
		CustomTextField(hint = "Confirm password", onChanged = {})
		
		TermsConditions()
		MarketingCheckbox()
		CommonYellowButton(label = "Created", onPressed = {
			navController.navigate(Screens.Home.route){
			
			}
		})
		
		
	}
}

@Composable
fun MarketingCheckbox() {
	Row(
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.Start,
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 10.dp)
	   
	   ) {
		Checkbox(
			checked = false,
			onCheckedChange = {},
			modifier = Modifier
				.padding(end = 8.dp)
				.size(20.dp),
			colors = CheckboxDefaults.colors(
				uncheckedColor = colorResource(R.color.Primary)
			                                
			                                )
		        
		        
		        )
		Text(
			"Marketing Promotions, News Letter", fontSize = 14.sp, fontWeight = FontWeight.SemiBold
		    )
		
	
	}
	Spacer(modifier = Modifier.height(50.dp))

	
}


@Composable
fun TermsConditions() {
	Row(
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.Start,
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 15.dp, bottom = 3.dp)
	   ) {
		Checkbox(
			checked = false,
			onCheckedChange = {},
			modifier = Modifier
				.padding(end = 8.dp)
				.size(20.dp),
			colors = CheckboxDefaults.colors(
				uncheckedColor = colorResource(R.color.Primary)
			                                
			                                )
		        
		        
		        )
		Text(
			"Terms & Conditions, Privacy policy", fontSize = 14.sp, fontWeight = FontWeight.SemiBold
		    )
	}
	
}

@Composable
fun CustomTextField(hint: String, onChanged: () -> Unit) {
	var textSelection by remember { mutableStateOf(hint) }
	
	TextField(
		
		
		colors = TextFieldDefaults.colors(
			focusedTextColor = Color.Gray,
			unfocusedTextColor = Color.Gray,
			
			disabledTextColor = Color.White,
			
			
			focusedContainerColor = Color(0xFFE7E7E6),
			unfocusedContainerColor = Color(0xFFE7E7E6),
			
			
			focusedIndicatorColor = Color.Transparent,
			unfocusedIndicatorColor = Color.Transparent,
			disabledIndicatorColor = Color.Transparent
		                                 
		                                 
		                                 ),
		
		textStyle = TextStyle(
			fontSize = 13.sp,
		                     ),
		value = textSelection,
		onValueChange = { it ->
			textSelection = it
		},
		modifier = Modifier
			.padding(top = 5.dp, bottom = 5.dp)
			.fillMaxWidth()
			.height(50.dp),
		shape = RoundedCornerShape(8.dp),
		
		
		)
}