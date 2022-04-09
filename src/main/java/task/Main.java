package task;

public class Main {

    public static void main(String[] args) {

        CarRepository carRepository = new CarRepository();
//        carRepository.save(new Car(null,"Audi","blue"));

        Car findCarById = carRepository.findById(1L);
//
//        System.out.println("Pet fundById: " + foundPetById);
//
//        petRepository.delete(fido);
//        petRepository.deleteById(2L);

    }
}
