package com.example.carrentalapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.carrentalapp.R

@Composable
fun CommonYellowButton(label:String, onPressed:()->Unit){
	
	Button(
		onClick = { onPressed() },
		modifier = Modifier
			.fillMaxWidth()
			
			.height(48.dp),
		colors = ButtonDefaults.buttonColors(
			containerColor = colorResource(R.color.Primary)
		                                    ),
		shape = RoundedCornerShape(8.dp)
	      ) {
		Text(text = label, color = Color.White)
	}
}