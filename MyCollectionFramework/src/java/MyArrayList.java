public class MyArrayList<E>{
    private int index = 0;
    private E[] innerArray = null;

    public  MyArrayList(){
        innerArray = (E[]) new Object[10];}

    public int size(){
        return innerArray.length;}

    private void grownInnerArray(int num ){
        E[] temp = (E[]) new Object[innerArray.length*num];
        System.arraycopy(innerArray, 0 ,temp, 0, innerArray.length);
        innerArray = temp;}



        public void add(E obj){
            innerArray[index] = obj;
            if(index++==size()-1){
                grownInnerArray(2);}
        }


        public void add(int index, E obj){
            if(index>=(size()-1)){
                grownInnerArray(index);
                for(int i = innerArray.length-1; i>index; i--){innerArray[i]=null;}}
            System.arraycopy(innerArray, index, innerArray, index+1, (size()-1)-index);
            innerArray[index] = obj;}

        public void remove(int index){
            int countOfElementMoved = size() - 1;
            System.arraycopy(innerArray, index+1, innerArray, index, countOfElementMoved);
            int size = size();
            innerArray[--size] = null;}

        public E get(int i){
            return innerArray[i];}

        public E remove(E obj){
            for(E object : innerArray){
                if(object.equals(obj)){
                    return object;}}
            return null;}}


