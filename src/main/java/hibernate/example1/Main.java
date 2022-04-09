package hibernate.example1;

public class Main {

    public static void main(String[] args) {

        // Session session = HibernateUtil.getSessionFactory().openSession();

        Pet fido = new Pet();
        fido.setName("Fido");
        fido.setAge(12);

        PetRepository petRepository = new PetRepository();
        petRepository.save(fido);
        petRepository.save(new Pet(null,"Rainius",12));

        Pet foundPetById = petRepository.findById(2L);
        System.out.println("Pet fundById: " + foundPetById);

        petRepository.delete(fido);
        petRepository.deleteById(2L);

    }
}
