package TextJustification;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static final String SPACE = " ";

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int wordLength = 0;
        List<String> todo = new ArrayList<>();
        for (String word : words) {
            if (todo.isEmpty() || wordLength + word.length() + 1 <= maxWidth) {
                if (!todo.isEmpty()) {
                    wordLength++;
                }
                wordLength += word.length();
                todo.add(word);
            } else {
                StringBuilder sb = new StringBuilder();
                if (todo.size() == 1) {
                    sb.append(todo.get(0));
                    for (int i = wordLength; i < maxWidth; i++) {
                        sb.append(SPACE);
                    }
                } else {
                    int[] extraSpace = null;
                    if(maxWidth > wordLength){
                        int count = maxWidth - wordLength;
                        extraSpace = new int[todo.size()-1];
                        int index = 0;
                        while (count > 0){
                            extraSpace[index]++ ;
                            count --;
                            index = (index + 1) % (todo.size() - 1);
                        }
                    }
                    for(int j=0; j<todo.size(); j++){
                        String todoWord = todo.get(j);
                        sb.append(todoWord);
                        if(j != todo.size()-1) {
                            sb.append(SPACE);
                            if(extraSpace != null) {
                                for (int i = 0; i < extraSpace[j]; i++) {
                                    sb.append(SPACE);
                                }
                            }
                        }
                    }
                }
                result.add(sb.toString());
                todo.clear();
                todo.add(word);
                wordLength = word.length();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<todo.size(); j++){
            String todoWord = todo.get(j);
            sb.append(todoWord);
            if(j != todo.size()-1) {
                sb.append(SPACE);
            }
        }
        if(wordLength < maxWidth){
            for (int i = wordLength; i < maxWidth; i++) {
                sb.append(SPACE);
            }
        }
        result.add(sb.toString());

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(solution.fullJustify(words, 16));
        String[] words1 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        System.out.println(solution.fullJustify(words1, 16));
        String[] words2 = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        System.out.println(solution.fullJustify(words2, 20));
    }

}
