public long[] solution3(long n){
    for(int i=2;i<=Math.sqrt(n);i++){
      if(n%i==0&&isPrime(i)&&isPrime(n/i))
        return new long[]{i,n/i};
    }

    return new long[] {-1,-1};
  }

  boolean isPrime(long num){
    if(num==1)return false;
    for(int i=2;i<=Math.sqrt(num);i++){
      if(num%2 == 0) return false;
    }
    return true;
  }
