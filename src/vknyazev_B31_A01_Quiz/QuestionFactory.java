/**
 * 
 */
package vknyazev_B31_A01_Quiz;

import java.util.StringTokenizer;

/**
 * @author slava
 *
 */
public class QuestionFactory {
    public static Question getQuestion(String questionData) {
        StringTokenizer st = new StringTokenizer(questionData, ", ");
        char questionType = st.nextToken().charAt(0);
        Question q = null;
        switch (questionType) {
        case 'F':
            q = makeFillInQuestion(st);
            break;
        case 'N':
            
            break;
        case 'S':

            break;
        case 'M':

            break;

        default:
            throw new InvalidQuestionDataException(questionType + " is not a valid question type.");
        }

        return q;
    }

    private static SingleChoiceQuestion makeSingleChoiceQuestion(StringTokenizer st) {
        
    }
    private static FillInQuestion makeFillInQuestion(StringTokenizer st) {
        String rawQuestionText = st.nextToken();
        int answerStart = rawQuestionText.indexOf('*');
        int answerEnd = rawQuestionText.lastIndexOf('*');

        // < 0 means there are no *, == means that there is only one, +1 == means that
        // the answer is empty
        if (answerStart < 0 || answerStart == answerEnd || answerStart + 1 == answerEnd)
            throw new InvalidQuestionDataException(
                    "A Fill-In-The-Blanks Question must contain an answer surrounded by *");

        String answer = rawQuestionText.substring(answerStart + 1, answerEnd - 1);
        String question = rawQuestionText.replace("*" + answer + "*", "__________");

        return new FillInQuestion(question, answer);
    }
}
