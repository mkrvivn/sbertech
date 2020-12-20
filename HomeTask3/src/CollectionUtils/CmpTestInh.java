package CollectionUtils;

class CmpTestInh extends CmpTest
{
    Integer i3;
    public CmpTestInh(Integer i1, Integer i2, Integer i3)
    {
        super(i1, i2);
        this.i3 = i3;
    }

    public int compareTo(CmpTestInh o) {
        if(i1.compareTo(o.i1) != 0)
        {
            return i1.compareTo(o.i1);
        }
        if(i2.compareTo(o.i2) != 0){
            return i2.compareTo(o.i2);
        }
        return i3.compareTo(o.i3);
    }

    @Override
    public String toString() {
        return super.toString() + " " + i3;
    }
}
