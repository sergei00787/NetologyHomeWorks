public class VehicleAdMain {
    public static void main(String[] args) {
        AdsService adsService = new AdsService();
        VehicleAd volvoAd = new VehicleAd("Volvo", "123", new PassengerType(),
                new SedanType(), new PetrolType());
        VehicleAd kamazAd = new VehicleAd("Kamaz", "45", new TruckType(),
                new PickupType(), new DieselType());

        adsService.setAdList(new VehicleAd[]{volvoAd, kamazAd});

        adsService.filterByVehicleTypeByPurpose(new PassengerType());

        adsService.filterByVehicleTypeByPurpose(new TruckType());

        VehicleAd kiaK5 = new VehicleAd("KIA", "5", new CarType(), new SedanType(), new PetrolType());
        VehicleAd kiaRio = new VehicleAd("KIA", "6", new CarType(), new SedanType(), new PetrolType());

        adsService.setAdList(new VehicleAd[]{kiaK5, kiaRio});
        adsService.filterByVehicleTypeByFuelTypes(new PetrolType());
    }

}
