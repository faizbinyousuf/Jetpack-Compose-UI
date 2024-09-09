package com.example.carrentalapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.carrentalapp.R

@Composable
fun HomeScreen(navController: NavController) {
	Column(
		
		  ) {
		
		CustomAppBar()
		Text(
			"Rent For",
			fontSize = 20.sp,
			fontWeight = FontWeight.Bold,
			modifier = Modifier.padding(start = 15.dp, top = 20.dp))
		CarGridView()
		ImageCarouselWithPager()
		CarSliders()
	}
}


@Composable
fun WalletComponent() {
	Column(
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.Start,
		
		
		) {
		
		Text(text = "My Wallet", fontWeight = FontWeight.SemiBold, fontSize = 10.sp)
		Spacer(modifier = Modifier.height(5.dp))
		
		
		Row(
			modifier = Modifier
				
				.padding(0.dp)
				
				.border(
					width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(6.dp)
				       )
				//			.padding(8.dp)
				.height(25.dp)
				.width(100.dp),
			verticalAlignment = Alignment.CenterVertically
		   ) {	   // Icon Box with Rounded Background
			Box(
				modifier = Modifier
					.size(25.dp)
					.background(Color(0xFFF5C06A), shape = RoundedCornerShape(5.dp)),
				contentAlignment = Alignment.Center
			   ) {
				Icon(
					imageVector = Icons.Filled.Email, // Your wallet icon resource
					contentDescription = "Wallet Icon",
					tint = Color.White,
					modifier = Modifier.size(16.dp)
				    )
			}
			
			Spacer(modifier = Modifier.width(12.dp)) // Spacer for spacing between icon and text
			
			// Text: $1000
			Text(
				text = "$1000", color = Color.Black, fontSize = 15.sp, fontWeight = FontWeight.Bold
			    )
		}
	}
}

@Composable
fun CustomAppBar() {
	Row(
		modifier = Modifier.fillMaxWidth()
			.padding(horizontal = 15.dp),
		verticalAlignment = Alignment.CenterVertically,
	
	   ) {
		Box(
			modifier = Modifier
				.background(
					color = Color.LightGray, shape = CircleShape
				           )
				.size(40.dp),
			contentAlignment = Alignment.Center
		   ) {
			Icon(imageVector = Icons.Filled.Person, contentDescription = null)
			
		}
		Spacer(modifier = Modifier.width(8.dp))
		Column {
			Text("Hello Faiz", fontWeight = FontWeight.Bold, fontSize = 17.sp)
			Text(text = "Welcome Back", fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
		}
		
		Spacer(modifier = Modifier.weight(1f))
		
		WalletComponent()
		
	}
}

@Composable
fun CarSliders() {
	val carList = listOf(
		R.drawable.slider_1,
		R.drawable.slider_2,
		R.drawable.slider_3,
		R.drawable.slider_1,
		R.drawable.slider_2,
		R.drawable.slider_3
	                    )
	LazyRow(modifier = Modifier.padding(11.dp)) {
		items(carList) { it ->
			var painter = painterResource(id = it)
			Image(
				painter = painter,
				contentDescription = "Carousel Image",
				contentScale = ContentScale.Crop,
				modifier = Modifier
					.height(200.dp)
					.padding(10.dp)
					.background(shape = RoundedCornerShape(10.dp), color = Color.White)
					.clip(RoundedCornerShape(12.dp))
			     
			     
			     )
		}
	}
}


@Composable
fun CarGridView() {
	
	LazyVerticalGrid(
		columns = GridCells.Fixed(2), // 2 columns
		modifier = Modifier.fillMaxWidth(),
		verticalArrangement = Arrangement.spacedBy(16.dp), // space between rows
		horizontalArrangement = Arrangement.spacedBy(16.dp), // space between columns
		contentPadding = PaddingValues(16.dp) // padding around the grid
	                ) {
		
		items(gridItems) { item ->
			GridItemViewNew(item)
		}
	}
	
	
}

@Composable
fun ImageCarouselWithPager() {
	
	val imageList = listOf(
		R.drawable.banner, R.drawable.banner, R.drawable.banner, R.drawable.banner
	                      )
	
	val pagerState = rememberPagerState(initialPage = 0, pageCount = { 3 })
	
	Column(
		modifier = Modifier.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally,
		
		) {
		
		
		HorizontalPager(
			pageSpacing = 10.dp,
			state = pagerState,
			
			modifier = Modifier
				.fillMaxWidth()
				.height(160.dp),
			
			
			) { page ->
			CarouselItem(imageResId = imageList[page])
		}
		LazyRow(
			modifier = Modifier.fillMaxWidth(), //				.height(10.dp),
			//				.background(color = Color.Black),
			horizontalArrangement = Arrangement.Center,
		       ) {
			
			items(pagerState.pageCount) { index ->
				
				var currentPage = index == pagerState.currentPage
				Box(
					
					modifier = Modifier
						.padding(horizontal = 1.5.dp)
						.width(if (currentPage) 25.dp else 8.dp)
						.height(4.dp)
						.background(
							shape = RoundedCornerShape(15.dp),
							color = if (currentPage) Color.LightGray else Color.LightGray.copy(alpha = .5f)
						           ),
					
					) {
					
				}
				
			}
		}
		
	}
}

@Composable
fun CarouselItem(imageResId: Int) {
	Card(
		modifier = Modifier.fillMaxWidth(),
		shape = RoundedCornerShape(0.dp)        //shape = RoundedCornerShape(16.dp),
		//		elevation = CardDefaults.cardElevation(8.dp)
	    ) {
		Box(modifier = Modifier.fillMaxWidth()) {
			Image(
				painter = painterResource(id = imageResId),
				contentDescription = "Carousel Image",
				contentScale = ContentScale.Crop,
				modifier = Modifier.fillMaxWidth()
			     ) //			Text(
			//				"get first day free on your first car booking".uppercase(),
			//				fontSize = 12.sp,
			//				textAlign = TextAlign.Center
			//				)
			Row(
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier.align(Alignment.Center)
			   
			   ) {
				Image(
					painter = painterResource(id = R.drawable.banner_car_no_bg),
					contentDescription = "Carousel Image",
					contentScale = ContentScale.FillHeight,
					modifier = Modifier
						.height(75.dp)
						.offset(y = 4.dp)
				     
				     )
				Column(modifier = Modifier.padding(start = 15.dp)) {
					Box(
						modifier = Modifier
							
							.background(color = Color.Black, RoundedCornerShape(6.dp))
							.padding(5.dp)
					   ) {
						Text(
							"Use Code: D110",
							color = Color.White,
							fontSize = 11.sp,
							fontWeight = FontWeight.Bold,
							
							)
						
					}
					Spacer(modifier = Modifier.height(6.dp))
					Text(
						"Explore Deal ->",
						color = Color.Black,
						fontWeight = FontWeight.Bold,
						fontSize = 11.sp
					    )
				}
				
			}
		}
	}
}

data class GridItem(
	val imageResId: Int, val label: String
                   )

val gridItems = listOf(
	GridItem(R.drawable.rent_car_1_no_bg, "Me"),
	GridItem(R.drawable.rent_car_1_no_bg, "My company"),
	GridItem(R.drawable.rent_car_3_no_bg, "Wedding"),
	GridItem(R.drawable.rent_car_3_no_bg, "Events")
                      )


@Composable
fun GridItemViewNew(item: GridItem) {
	Card(
		modifier = Modifier
			.fillMaxWidth()
			.height(135.dp), // Set a fixed height
		shape = RoundedCornerShape(16.dp), // Rounded corners
		colors = CardDefaults.cardColors(
			containerColor = colorResource(R.color.AppGray)
		                                ), //		elevation = CardDefaults.cardElevation(8.dp) // Adding elevation for shadow effect
	    ) {
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.padding(8.dp), // Padding inside the card
			contentAlignment = Alignment.Center
		   ) {
			Column(
				horizontalAlignment = Alignment.CenterHorizontally,
				modifier = Modifier.fillMaxWidth()
			      ) {                // Image
				Image(
					painter = painterResource(id = item.imageResId),
					contentDescription = item.label,
					modifier = Modifier.size(80.dp),
					contentScale = ContentScale.Fit
				     )
				
				// Label
				Text(
					text = item.label,
					fontSize = 16.sp,
					fontWeight = FontWeight.Bold,
					color = Color.Black,
					modifier = Modifier.padding(top = 8.dp)
				    )
			}
			
			// Info Icon in the top right corner
			Box(
				modifier = Modifier
					.align(Alignment.TopEnd)
					.padding(8.dp)
			   ) {
				Icon(
					imageVector = Icons.Default.Info, // Your info icon resource
					contentDescription = "Info", tint = Color.Gray, modifier = Modifier.size(20.dp)
				    )
			}
		}
	}
}

@Composable
fun GridItemView(item: GridItem) {
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.height(150.dp) // Set a fixed height
			.background(Color.LightGray), // Background color
		contentAlignment = Alignment.Center
	   ) {
		Column(
			horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(8.dp)
		      ) {            // Image
			Image(
				painter = painterResource(id = item.imageResId),
				contentDescription = item.label,
				modifier = Modifier.size(80.dp),
				contentScale = ContentScale.Fit
			     )
			
			// Label
			Text(
				text = item.label,
				fontSize = 16.sp,
				fontWeight = FontWeight.Bold,
				color = Color.Black
			    )
		}
		
		// Info Icon in the top right corner
		Box(
			modifier = Modifier
				.align(Alignment.TopEnd)
				.padding(8.dp)
		   ) {
			Icon(
				painter = painterResource(id = androidx.core.R.drawable.ic_call_decline), // Your info icon resource
				contentDescription = "Info", tint = Color.Gray, modifier = Modifier.size(20.dp)
			    )
		}
	}
}