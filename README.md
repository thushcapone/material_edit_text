
# Welcome to Material Edit Text Widget!  
  
[![](https://jitpack.io/v/thushcapone/material_edit_text.svg)](https://jitpack.io/#thushcapone/material_phone_widget)   
  
MaterialEditText is your cool edit text that is Android Architecture Component friendly, compatible with Data-Binding and two ways binding  
  
### Demo  
![gif of MaterialEditText](https://raw.githubusercontent.com/thushcapone/material_edit_text/master/screenshots/demo-material-edit.gif)  
  
  
## Adding to project  
  
### Gradle  
Add below code to your **root** `build.gradle` file (if you have multiple modules and only one of them require `MaterialEditText`, add the `jitpack` url only in that module's `build.gradle`).  
```groovy  
allprojects {  
 repositories { 
	 maven { 
		 url 'https://jitpack.io' 
		 } 
	 }
}  
```  
And add the following dependency code to your **module**'s `build.gradle` file.  
```groovy  
dependencies {  
 implementation "com.github.thushcapone:material_edit_text:${latest-version}"
}  
```  
  
## Usage  
```xml  
<com.thushcapone.material_edit_text.MaterialEditText    
  android:layout_width="match_parent"    
  android:layout_height="wrap_content"    
  android:layout_gravity="center"    
  app:hint="This is a test"    
  app:inputType="textCapWords"   
  />  
```  
  
## Usage with MVVM + DataBinding  
```xml  
<com.thushcapone.material_edit_text.MaterialEditText 
  android:id="@+id/phone_number_login"    
  android:layout_width="match_parent"    
  android:layout_height="wrap_content"    
  android:layout_gravity="center"    
  app:hint="Enter your phone number"  
  app:inputType="phone" 
  bind:text="@={viewModel.phoneNumber}"
  bind:error="@{viewModel.errorPhoneNumber}"    
  />  
```  
  
### Customization  
  
Table below describes the properties available to customize the MaterialEditText.  
  
  
| Property Name          | Format    | Description |  
|------------------------|-----------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|  
| hint            | reference     | Set the string resource used as the default hint                             |  
| inputType            | reference | Set the input type |  
| enabled            | boolean | Set the enable status |  
| text           | binding-value | Will receive the value of the text typed  |  
| error                | binding-value | Will be called when an error has been reached and show the error specified |
| mutableEnabled                | binding-value | Will set the enable status when changed |  
  
# License  
```  
Copyright (c) 2019. T.C.  
  
Licensed under the Apache License, Version 2.0 (the "License");  
you may not use this file except in compliance with the License.  
You may obtain a copy of the License at  
  
 http://www.apache.org/licenses/LICENSE-2.0  
Unless required by applicable law or agreed to in writing, software  
distributed under the License is distributed on an "AS IS" BASIS,  
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  
See the License for the specific language governing permissions and  
limitations under the License. 
```