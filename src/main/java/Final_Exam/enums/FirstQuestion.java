package Final_Exam.enums;

public enum FirstQuestion {
	DFS_Q(
		"<html>" +
        	"<div style='text-align: center;'>" + "what is this search ? <br>You can answer in either uppercase or lowercase letters.<br>" +
	        "If the answer contains a space, use _ instead (for example: Number_One).<br><br>" +
        	"</div>" +
	        "<pre>" +
        	"static boolean Search(Tree head, int n) {\n" +
        	"	if (head == null) return false;\n" +
        	"	if (head.data == n) return true;\n" +
        	"    	return Search(head.left, n) || Search(head.right, n);\n" +
        	"}" +
        	"</pre>" +
        	"</html>"
	),
	BINARY_SEARCH_Q(
		"<html>" +
        	"<div style='text-align: center;'>" +
        	"what is this search ? <br>You can answer in either uppercase or lowercase letters.<br>" +
        	"If the answer contains a space, use _ instead (for example: Number_One).<br><br>" +
        	"</div>" +
        	"<pre>" +
        	"public int search(int left, int right, int n) {\n" +
        	"    	if (left &gt; right) return -1;\n" +
        	"    	int mid = left + (right - left) / 2;\n" +
        	"    	if (this.arr[mid] == n) return mid;\n" +
        	"    	if (this.arr[mid] &gt; n) return search(left, mid - 1, n);\n" +
        	"    	return search(mid + 1, right, n);\n" +
        	"}\n\n" +
        	"public int search(int n) {\n" +
        	"    	int left = 0;\n" +
        	"    	int right = this.arr.length - 1;\n" +
        	"    	return search(left, right, n);\n" +
        	"}" +
        	"</pre>" +
        	"</html>"
	),
	INSERTION_SORT_Q(
		"<html>" +
        	"<div style='text-align: center;'>" +
        	"what is this sort ? <br>You can answer in either uppercase or lowercase letters.<br>" +
        	"If the answer contains a space, use _ instead (for example: Number_One).<br><br>" +
        	"</div>" +
        	"<pre>" +
        	"for (int i = 1; i &lt; 10000; i++) {\n" +
        	"    	int j = i;\n" +
        	"    	while (j - 1 &gt;= 0 &amp;&amp; number[j] &lt; number[j - 1]) {\n" +
        	"       	number[j - 1] += number[j];\n" +
        	"        	number[j] = number[j - 1] - number[j];\n" +
        	"        	number[j - 1] -= number[j];\n" +
        	"        	j--;\n" +
        	"    	}\n" +
        	"}" +
        	"</pre>" +
        	"</html>"
	),
	MERGE_SORT_Q(
		"<html>" +
		"<div style='text-align: center;'>" +
		"What is this sort ? <br>You can answer in either uppercase or lowercase letters.<br>" +
        	"If the answer contains a space, use _ instead (for example: Number_One).<br><br>" +
        	"</div>" +
		"<pre>" +
		"public class Main {\n" +
		"    	public static void main(String[] args) {\n" +
		"        	sort(numbers, 0, numbers.length - 1);\n" +
		"    	}\n" +
		"    	public static void sort(int[] array, int left, int right) {\n" +
		"        	if (left &lt; right) {\n" +
		"            		int middle = left + (right - left) / 2;\n" +
		"            		sort(array, left, middle);\n" +
		"            		sort(array, middle + 1, right);\n" +
		"            		subSort(array, left, middle, right);\n" +
		"        	}\n" +
		"    	}\n" +
		"    	public static void subSort(int[] array, int left, int middle, int right) {\n" +
		"        	int leftSize = middle - left + 1;\n" +
		"        	int rightSize = right - middle;\n" +
		"        	int[] leftArray = new int[leftSize];\n" +
		"        	int[] rightArray = new int[rightSize];\n" +
		"        	for (int i = 0; i &lt; leftSize; i++) {\n" +
		"            		leftArray[i] = array[left + i];\n" +
		"        	}\n" +
		"        	for (int j = 0; j &lt; rightSize; j++) {\n" +
		"            		rightArray[j] = array[middle + 1 + j];\n" +
		"        	}\n" +
		"        	int i = 0, j = 0, k = left;\n" +
		"        	while (i &lt; leftSize &amp;&amp; j &lt; rightSize) {\n" +
		"            		if (leftArray[i] &lt;= rightArray[j]) {\n" +
		"                		array[k] = leftArray[i];\n" +
		"                		i++;\n" +
		"            		} else {\n" +
		"                		array[k] = rightArray[j];\n" +
		"                		j++;\n" +
		"            		}\n" +
		"            		k++;\n" +
		"        	}\n" +
		"        	while (i &lt; leftSize) {\n" +
		"            		array[k] = leftArray[i];\n" +
		"            		i++;\n" +
		"            		k++;\n" +
		"        	}\n" +
		"        	while (j &lt; rightSize) {\n" +
		"            		array[k] = rightArray[j];\n" +
		"            		j++;\n" +
		"            		k++;\n" +
		"        	}\n" +
		"    	}\n" +
		"}" +
		"</pre>" +
		"</html>"
	),
	SELECTION_SORT(
		"<html>" +
		"<div style='text-align: center;'>" +
		"What is this sort ? <br>You can answer in either uppercase or lowercase letters.<br>" +
        	"If the answer contains a space, use _ instead (for example: Number_One).<br><br>" +
        	"</div>" +
        	"<pre>" +
        	"public static void mystery(int[] arr) {\n" +
        	"    	int n = arr.length;\n" +
        	"    	for (int i = 0; i &lt; n - 1; i++) {\n" +
        	"        	int minIndex = i;\n" +
        	"        	for (int j = i + 1; j &lt; n; j++) {\n" +
        	"            		if (arr[j] &lt; arr[minIndex]) {\n" +
		"                		minIndex = j;\n" +
		"            		}\n" +
		"        	}\n" +
		"        	int temp = arr[i];\n" +
		"        	arr[i] = arr[minIndex];\n" +
		"        	arr[minIndex] = temp;\n" +
		"    	}\n" +
		"}" +
		"</pre>" +
		"</html>"
	),
	BUBBLE_SORT(
		"<html>" +
		"<div style='text-align: center;'>" +
		"What is this sort ? <br>You can answer in either uppercase or lowercase letters.<br>" +
        	"If the answer contains a space, use _ instead (for example: Number_One).<br><br>" +
        	"</div>" +
		"<pre>" +
		"public static void mystery(int[] arr) {\n" +
		"    	int n = arr.length;\n" +
		"    	for (int i = 0; i &lt; n - 1; i++) {\n" +
		"        	for (int j = 0; j &lt; n - i - 1; j++) {\n" +
		"            		if (arr[j] &gt; arr[j + 1]) {\n" +
		"                		int temp = arr[j];\n" +
		"                		arr[j] = arr[j + 1];\n" +
		"                		arr[j + 1] = temp;\n" +
		"            		}\n" +
		"        	}\n" +
		"    	}\n" +
		"}" +
		"</pre>" +
		"</html>"
	),
	QUICK_SORT(
		"<html>" +
		"<div style='text-align: center;'>" +
		"What is this sort ? <br>You can answer in either uppercase or lowercase letters.<br>" +
        	"If the answer contains a space, use _ instead (for example: Number_One).<br><br>" +
        	"</div>" +
        	"<pre>" +
        	"public static void mystery(int[] arr, int left, int right) {\n" +
        	"	if (left &gt;= right) return;\n\n" +
        	"    	int pivot = arr[right];\n" +
		"    	int i = left - 1;\n" +
		"    	for (int j = left; j &lt; right; j++) {\n" +
		"        	if (arr[j] &lt; pivot) {\n" +
		"            		i++;\n" +
		"            		int temp = arr[i];\n" +
		"            		arr[i] = arr[j];\n" +
		"            		arr[j] = temp;\n" +
		"        	}\n" +
		"    	}\n" +
		"    	int temp = arr[i + 1];\n" +
		"    	arr[i + 1] = arr[right];\n" +
		"    	arr[right] = temp;\n" +
		"    	int pi = i + 1;\n" +
		"    	mystery(arr, left, pi - 1);\n" +
		"    	mystery(arr, pi + 1, right);\n" +
		"}" +
		"</pre>" +
		"</html>"	
	),
	BREADTH_FIRST_SEARCH(
		"<html>" +
		"<div style='text-align: center;'>" +
		"What is this search ? <br>You can answer in either uppercase or lowercase letters.<br>" +
        	"If the answer contains a space, use _ instead (for example: Number_One).<br><br>" +
        	"</div>" +
		"<pre>" +
		"public static void mystery(List&lt;List&lt;Integer&gt;&gt; graph, int start) {\n" +
		"    	boolean[] visited = new boolean[graph.size()];\n" +
		"    	Queue&lt;Integer&gt; queue = new LinkedList&lt;&gt;();\n\n" +
		"    	visited[start] = true;\n" +
		"    	queue.add(start);\n\n" +
		"    	while (!queue.isEmpty()) {\n" +
		"        	int node = queue.poll();\n" +
		"        	System.out.print(node + \" \");\n\n" +
		"        	for (int neighbor : graph.get(node)) {\n" +
		"            		if (!visited[neighbor]) {\n" +
		"                		visited[neighbor] = true;\n" +
		"                		queue.add(neighbor);\n" +
		"            		}\n" +
		"        	}\n" +
		"    	}\n" +
		"}" +
		"</pre>" +
		"</html>"
	),
	LINEAR_SEARCH(
		"<html>" +
		"<div style='text-align: center;'>" +
		"What is this search ? <br>You can answer in either uppercase or lowercase letters.<br>" +
		"If the answer contains a space, use _ instead (for example: Number_One).<br><br>" +	
		"</div>" +
		"<pre>" +
		"public static int mystery(int[] arr, int target) {\n" +
			"for (int i = 0; i < arr.length; i++) {\n" +
				"if (arr[i] == target) return i;\n" +
			"}\n" +
			"return -1;\n" +	
		"}\n" +
		"</pre>" +
		"</html>"	
	);

	private final String questionHtml;

	/**
	 * Constructs a FirstQuestion enum constant with the specified HTML content.
	 *
	 * @param questionHtml The Html string containing the question instructions.	
	 */
	FirstQuestion(String questionHtml) {
		this.questionHtml = questionHtml;
	}

	/**
	 * Retrieves the HTML-formatted string for the question.
	 *
	 * @return the Html string containing the question content.
	 */
	public String getQuestionHtml() {
		return questionHtml;
	}
}
