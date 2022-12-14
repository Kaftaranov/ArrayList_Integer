import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class IntegerList_Impl implements IntegerListInterface {
   
        Integer[] integerTestList = new Integer[100_000];
        private void testListInitialization() {
            Random value = new Random();
            for (int i = 0; i < integerList.length; i++) {
                integerList[i] = value.nextInt(0, 500_000);
            }
        }

        Integer[]integerList = new Integer[16];
        Integer[] shiftLeft(int index){
            for (int i = index; i < integerList.length; i++){
                integerList[i] = integerList[i+1];
                if (i == integerList.length - 2){
                    integerList[i+1] = null;
                    break;
                }
            }
            return integerList;
        }
        Integer[] shiftRight(int index){
            if (integerList[integerList.length-1] != null){
                throw new RuntimeException("Index is out of bounds");
            }
            for (int i = size(); i >= index ; i--){
                integerList[i+1] = integerList[i];
            }
            return integerList;
        }

        @Override
        public Integer add(Integer item) {
            if(size() == 0){
                return integerList[0] = item;
            }
            return integerList[(size()+1)] = item;
        }

        @Override
        public Integer add(Integer index, Integer item) {
            if (index > size() || index > integerList.length){
                throw new RuntimeException("Index is out of bounds");
            }
            shiftRight(index);
            return integerList[index] = item;
        }

        @Override
        public Integer set(Integer index, Integer item) {
            if (index > size() || index > integerList.length){
                throw new RuntimeException("Index is out of bounds");
            }
            return integerList[index] = item;
        }

        @Override
        public Integer removeByValue(Integer item) {
            for (int i = 0; i < integerList.length; i++) {
                if (integerList[i].equals(item)) {
                    shiftLeft(i);
                    return item;
                }
            }
            throw new RuntimeException("Item not found");
        }

        @Override
        public Integer removeByIndex(int index) {
            Integer removedItem;
            if (integerList[index] != null){
                removedItem = integerList[index];
                shiftLeft(index);
            }else{
                throw new RuntimeException("Index not found");
            }
            return removedItem;
        }

        @Override
        public boolean contains(Integer item) {
            for (Integer e : integerList) {
                return Objects.equals(e, item);
            }
            return false;
        }

        @Override
        public int indexOf(Integer item) {
            for (int i = 0; i < integerList.length; i++) {
                if (integerList[i].equals(item)){
                    return i;
                }
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Integer item) {
            for (int i = integerList.length-1; i >= 0; i--) {
                if (integerList[i].equals(item)){
                    return i;
                }
            }
            return -1;
        }

        @Override
        public Integer get(Integer index) {
            if (index > size()) {
                throw new RuntimeException("Index is out of bounds");
            }
            return integerList[index];
        }

        @Override
        public boolean equals(IntegerListInterface otherList) {
            if (otherList.size() != size()) {
                return false;
            }
            for (int i = 0; i < integerList.length; i++) {
                if (!integerList[i].equals(otherList.get(i))){
                    return false;
                }
            }
            return true;
        }

        @Override
        public int size() {
            int n = 0;
            for (Integer e : integerList) {
                if (e != null) {
                    n++;
                }
            }
            return n;
        }

        @Override
        public boolean isEmpty() {
            for (Integer e : integerList) {
                if (e != null) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public void clear() {
            Arrays.fill(integerList, null);
        }

        @Override
        public Integer[] toArray() {
            Integer[] newArray = new Integer[size()];
            for (int i = 0; i < size(); i++) {
                newArray[i] = integerList[i];
            }
            return newArray;
        }
    }

