package interviewQuestions;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class TestResult {
	int studentId;
	String testDate;
	int testScore;
}

public class FinalScoreQuestion {
	Map<Integer, Double> calculateFinalScores(List<TestResult> results) {
		if (results == null || results.size() == 0)
			return null;
		HashMap<Integer, PriorityQueue<Integer>> id_scores = new HashMap<Integer, PriorityQueue<Integer>>();
		for (TestResult res : results) {
			PriorityQueue<Integer> queue = null;
			if (id_scores.containsKey(res.studentId)) {
				queue = id_scores.get(res.studentId);
			} else {
				queue = new PriorityQueue<Integer>(5, Collections.reverseOrder());
			}
			queue.offer(res.testScore);
			id_scores.put(res.studentId, queue);
		}

		Map<Integer, Double> averages = new HashMap<Integer, Double>();
		for (int key : id_scores.keySet()) {
			PriorityQueue<Integer> queue = id_scores.get(key);
			double avg = 0;
			for (int i = 0; i < 5; i++)
				avg += queue.poll();
			avg /= 5;
			averages.put(key, avg);
		}
		return averages;
	}
}
