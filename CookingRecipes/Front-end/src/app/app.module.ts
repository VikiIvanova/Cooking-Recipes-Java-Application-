import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomePageComponent } from './components/home-page/home-page.component';
import { MaterialUIModule } from './material-ui/material-ui.module';
import { HeaderComponent } from './components/header/header.component';
import { LoginComponent } from './components/login/login.component';
import { SearchBarComponent } from './components/search-bar/search-bar.component';
import { HttpClientModule } from '@angular/common/http';
import { RecipeService } from './services/recipe.service';
import { MatIconModule } from '@angular/material/icon';
import { RegisterPageComponent } from './components/register-page/register-page.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RecipeListComponent } from './components/recipes/recipe-list/recipe-list.component';
import { RecipeDetailsComponent } from './components/recipes/recipe-details/recipe-details.component';
import { CommentDialogComponent } from './components/comment-dialog/comment-dialog.component';
import { RecipeFavoriteComponent } from './components/recipes/recipe-favorite/recipe-favorite.component';
import { StarRatingComponent } from './components/star-rating/star-rating.component';
import { RecipeAddComponent } from './components/recipes/recipe-add/recipe-add.component';


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    HeaderComponent,
    LoginComponent,
    SearchBarComponent,
    RegisterPageComponent,
    RecipeListComponent,
    RecipeDetailsComponent,
    CommentDialogComponent,
    RecipeFavoriteComponent,
    StarRatingComponent,
    RecipeAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialUIModule,
    HttpClientModule,
    MatIconModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [RecipeService],
  bootstrap: [AppComponent],
})
export class AppModule {}
