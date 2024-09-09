package com.example.carrentalapp.ui.screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.carrentalapp.R

@Composable
fun LoginScreen(modifier: Modifier = Modifier, navController: NavController) {
	
	Box(
	   ) {
		
		BackGroundImage()
		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Top,
			modifier = Modifier
				.fillMaxSize()
				.padding(horizontal = 20.dp)
		      
		      ) {
			Spacer(modifier = Modifier.weight(.9f))
			Column(
				horizontalAlignment = Alignment.CenterHorizontally,
				modifier = Modifier
					.fillMaxWidth()
					.weight(1f)
			      ) {
				Logo()
				
				Spacer(modifier = Modifier.height(35.dp))
				CustomButton("Continue with Phone number", onClick = {})
				CustomButton("Login with Google", onClick = {})
				CustomButton("Create an Account", onClick = {
					
					navController.navigate("createAccount"){
					}
				})
				Spacer(modifier = Modifier.height(10.dp))
				TermsAndConditions()
				Spacer(modifier = Modifier.height(20.dp))
			}
			
			
		}
		
	}
	
}

@Composable
fun TermsAndConditions() {
	Text(
		text = "Terms & Conditions, Privacy Policy",
		fontWeight = FontWeight.Bold,
		color = Color.White,
		fontSize = 13.sp,
		textDecoration = TextDecoration.Underline,
	    )
}

@Composable
fun Logo() {
	var painter = painterResource(id = R.drawable.logo_svg)
	Column(
		modifier = Modifier.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally,
	      ) {
		Image(
			painter = painter, contentDescription = null,
			
			contentScale = ContentScale.Crop,
			
			//		modifier = Modifier
			//			.fillMaxWidth()
		     )
		
		Spacer(modifier = Modifier.height(10.dp))
		Text(
			"Company Logo Here",
			fontWeight = FontWeight.W700,
			color = Color.White,
			
			)
	}
}

@Composable
fun CustomButton(label: String, onClick:  () -> Unit) {
	OutlinedButton(
		
		
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 5.dp, bottom = 5.dp),
		
		shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(
			contentColor = Color.White,
			containerColor = Color.Transparent,
			
			), border = BorderStroke(0.5.dp,  colorResource(R.color.Primary) ),
		
		
		onClick = {
			
			onClick()
		}
	              
	              ) {
		Text(
			label, fontSize = 13.sp,
			fontWeight = FontWeight.Bold,
		    )
		
		
	}
}

@Composable
fun BackGroundImage() {
	var painter = painterResource(id = R.drawable.bg)
	
	val matrix = ColorMatrix()
	matrix.setToSaturation(0F)
	Image(
		painter = painter,
		contentDescription = null,
		
		contentScale = ContentScale.Crop,
		colorFilter = ColorFilter.colorMatrix(matrix),
		modifier = Modifier.fillMaxWidth()
	     
	     
	     )
}