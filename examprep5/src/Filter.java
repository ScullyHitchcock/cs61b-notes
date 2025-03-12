public class Filter implements Predicate<Integer>{
    @Override
    public boolean test(Integer x) {
        return x.equals(1);
    }
}
