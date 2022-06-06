//String answer = sol.solution2(6, new int[][] {{1, 3, 1}, {3, 5, 0}, {5, 4, 0}, {2, 5, 0}});
//result = O?O?X?

public String solution2(int n, int[][] delivery) {
    // 0 = ?, 1 = X, 2 = O
    int[] results = new int[n+1];

    for (int[] del : delivery) {
      if (del[2] == 1) {
        results[del[0]] = 2;
        results[del[1]] = 2;
      } else if (del[2] == 0) {
        if (results[del[0]] == 2) {
          results[del[1]] = 1;
        } else if (results[del[1]] == 2) {
          results[del[0]] = 1;
        }
      }
    }

    return Arrays.stream(results)
        .boxed().skip(1)
        .map(
            i -> {
              if (i == 0) return "?";
              else if (i == 1) return "X";
              else return "O";
            })
        .collect(Collectors.joining());
  }
