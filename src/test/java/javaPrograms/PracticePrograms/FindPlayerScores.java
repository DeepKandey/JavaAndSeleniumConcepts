package javaPrograms.PracticePrograms;

import java.util.Arrays;

public class FindPlayerScores {

  public static void main(String[] args) {

    /*Output:
    Total Score: 20 - Solved
    Batsman 1 Score : 4 (1 + 3)
    Batsman 2 Score : 16 (2 + 4 + 1 + 6 + 2 + 1)
    */

    HashMap<String, String> map = new HashMap<>();
    map.put("Batsman 1", "0");
    map.put("Batsman 2", "0");

    String[] batsmanArray = new String[] {"Batsman 1", "Batsman 2"};

    StringBuilder batsmanOnStrike = new StringBuilder(batsmanArray[0]);

    int[] arr = new int[] {1, 2, 0, 0, 4, 1, 6, 2, 1, 3};

    for (int i = 0; i < arr.length; i++) {

      var equals = batsmanOnStrike.toString().equals(batsmanArray[0]);

      if (i == 0 && arr[i] != 0) {
        map.put(batsmanOnStrike.toString(), map.get(batsmanOnStrike.toString()) + " + " + arr[i]);
        if ((arr[i] % 2) != 0) {
          batsmanOnStrike.setLength(0);
          batsmanOnStrike.append(batsmanArray[1]);
        }
      } else if (arr[i] % 2 != 0 && arr[i] != 0) {
        map.put(batsmanOnStrike.toString(), map.get(batsmanOnStrike.toString()) + " + " + arr[i]);
        if ((i + 1) % 6 != 0) {
          batsmanOnStrike.setLength(0);
          if (equals) {
            batsmanOnStrike.append(batsmanArray[1]);
          } else {
            batsmanOnStrike.append(batsmanArray[0]);
          }
        }
      } else if (arr[i] % 2 == 0 && arr[i] != 0) {
        map.put(batsmanOnStrike.toString(), map.get(batsmanOnStrike.toString()) + " + " + arr[i]);
      }

      if ((i + 1) % 6 == 0 & arr[i] % 2 == 0) {
        batsmanOnStrike.setLength(0);
        if (equals) {
          batsmanOnStrike.append(batsmanArray[1]);
        } else {
          batsmanOnStrike.append(batsmanArray[0]);
        }
      }
    }

    String Batsman1scoreList =
        map.get(batsmanArray[0]).replaceFirst("^0+(?!$)", "").replaceFirst("\\+", "").trim();
    String Batsman2scoreList =
        map.get(batsmanArray[1]).replaceFirst("^0+(?!$)", "").replaceFirst("\\+", "").trim();

    int batsman1Score =
        Arrays.stream(
                map.get(batsmanArray[0])
                    .replaceFirst("^0+(?!$)", "")
                    .replaceFirst("\\+", "")
                    .trim()
                    .split("\\+", 0))
            .map(s -> s.trim())
            .mapToInt(Integer::parseInt)
            .sum();

    int batsman2Score =
        Arrays.stream(
                map.get(batsmanArray[1])
                    .replaceFirst("^0+(?!$)", "")
                    .replaceFirst("\\+", "")
                    .trim()
                    .split("\\+", 0))
            .map(s -> s.trim())
            .mapToInt(Integer::parseInt)
            .sum();

    System.out.println("Total score: " + IntStream.of(arr).sum());
    System.out.println("Batsman 1 Score: " + batsman1Score + " (" + Batsman1scoreList + ")");
    System.out.println("Batsman 2 Score: " + batsman2Score + " (" + Batsman2scoreList + ")");
  }
}
