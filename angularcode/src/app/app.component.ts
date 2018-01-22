import { Component } from '@angular/core';
import {  Platform } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { LoginPage } from '../pages/login/login';

@Component({
  templateUrl: 'app.html'
})
export class MyApp {
  //@ViewChild(Nav) nav: Nav;

  public rootPage: any = LoginPage;

  //pages: Array<{ title: string, component: any }>;

  constructor(public platform: Platform, public statusBar: StatusBar, public splashScreen: SplashScreen) {
    this.initializeApp();

    // used for an example of ngFor and navigation
   /* this.pages = [
      { title: 'Home', component: HomePage },
      { title: 'My Profile', component: HomePage },
      { title: 'Contribute to Farmers Account', component: 'ContributeFarmersPage' },
      { title: 'Farmers Details', component: 'FarmerFullDetailsPage' },
      { title: 'My Transactions', component: 'MyTransactionsPage' },
      { title: 'Benefited Farmers', component: 'BenefittedFarmersPage' },
      { title: 'Contributors List', component: 'ContributorsPage' },
      { title: 'Contact Us', component: 'ContactmePage' },
      { title: 'Rate SaveFarmer', component: HomePage },
      { title: 'Logout', component: HomePage }
    ];*/

  }

  initializeApp() {
    this.platform.ready().then(() => {
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      this.statusBar.styleDefault();
      this.splashScreen.hide();
    });
  }
/*
  openPage(page) {
    // Reset the content nav to have just this page
    // we wouldn't want the back button to show in this scenario
    //this.nav.setRoot(page.component);
    
    if (page.title == "Home") {
      this.nav.setRoot(page.component);
    }
    else {
      this.nav.push(page.component);
    }

  }*/
}
