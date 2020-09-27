package algorithm.others.basic.lesson04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/9/10 10:12
 */
public class CatDogQueueDemo {
    public static void main(String[] args) {
        CatDogQueue test = new CatDogQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isDogQueueEmpty()) {
            System.out.println(test.pollDog().getType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getType());
        }


    }
}

 class Pet{
    private String type;

    public Pet(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }
}

 class Dog extends Pet{
    public Dog(){
        super("dog");
    }
}

class Cat extends Pet{
    public Cat(){
        super("cat");
    }
}

class PetBar{
    Pet pet;
    int count;

    public PetBar(Pet pet, int count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

class CatDogQueue{
    private Queue<PetBar> queueDog;
    private Queue<PetBar> queueCat;
    int count;

    public CatDogQueue() {
        this.queueDog = new LinkedList<PetBar>();
        this.queueCat = new LinkedList<PetBar>();
        count = 0;
    }

    public void add(Pet pet){
        if ("dog".equals(pet.getType())){
            queueDog.add(new PetBar(pet,this.count));
            this.count++;
        }else if("cat".equals(pet.getType())){
            queueCat.add(new PetBar(pet, this.count));
            this.count++;
        }else {
            throw new RuntimeException("input error");
        }
    }

    public Dog pollDog(){
        if (queueDog.isEmpty()){
            throw new RuntimeException();
        }
        return (Dog) queueDog.poll().getPet();
    }

    public Cat pollCat(){
        if (queueCat.isEmpty()){
            throw new RuntimeException();
        }
        return (Cat) queueCat.poll().getPet();
    }

    public Pet pollAll(){
        if (queueCat.isEmpty() && queueDog.isEmpty()){
            throw new RuntimeException();
        }else if(queueDog.isEmpty()){
            return queueCat.poll().getPet();
        }else if (queueCat.isEmpty()){
            return queueDog.poll().getPet();
        }else{
            Pet pet = queueDog.peek().getCount() < queueCat.peek().getCount() ? queueDog.poll().getPet() :  queueCat.poll().getPet();
            return pet;
        }
    }

    public  boolean isDogQueueEmpty(){
        return queueDog.isEmpty();
    }

    public boolean isCatQueueEmpty(){
        return queueCat.isEmpty();
    }

    public boolean isEmpty(){
        return queueCat.isEmpty() && queueDog.isEmpty();
    }




}



