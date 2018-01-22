import { Component, OnInit } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { FetchServiceProvider } from '../../providers/fetch-service/fetch-service';
/**
 * Generated class for the FarmerFullDetailsPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-farmer-full-details',
  templateUrl: 'farmer-full-details.html',
})
export class FarmerFullDetailsPage implements OnInit {
  farmerDetails: any;
  pendingFarmerDetails: any = [];
  constructor(public service: FetchServiceProvider, public navCtrl: NavController, public navParams: NavParams) {
  }

  ngOnInit() {
    this.service.fetchFarmerDetails().subscribe(res => {
      this.farmerDetails = res['farmerDetails'];
      for (var i = 0; i < this.farmerDetails.length; i++) {
        if (this.farmerDetails[i].amountPending > 0) {
          this.pendingFarmerDetails.push(this.farmerDetails[i]);
        }
      }
    })
  }

}
