import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomePageComponent } from './components/home-page/home-page.component';
import {MaterialUIModule} from "./material-ui/material-ui.module";
import { HeaderComponent } from './components/header/header.component';
import { LoginComponent } from './components/login/login.component';
import { SearchBarComponent } from './components/search-bar/search-bar.component';
import {HttpClientModule} from "@angular/common/http";
import {RecipeService} from "./services/recipe.service";
import { FormsModule } from '@angular/forms';
import {MatIconModule} from "@angular/material/icon";

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    HeaderComponent,
    LoginComponent,
    SearchBarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialUIModule,
    HttpClientModule,
    FormsModule,
    MatIconModule
  ],
  providers: [RecipeService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
