public class MeanObject {
    static int INIT_HASH_CODE = 1;
    int hashCode = INIT_HASH_CODE;

    public MeanObject() {
    }

   public int hashCode()	{
	hashCode ++;
	if ( hashCode > 10 )
		hashCode = INIT_HASH_CODE;
	return hashCode;

   }
}

