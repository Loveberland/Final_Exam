package Final_Exam.enums;

public enum FirstQuestion {
	DFS_Q(
		"<html>" +
        	"<div style='text-align: center;'>" +
        	"what is this search ? <br>You can answer in either uppercase or lowercase letters.<br>" +
	        "If the answer contains a space, use _ instead (for example: Number_One).<br><br>" +
        	"</div>" +
	        "<pre>" +
        	"static boolean Search(Tree head, int n) {\n" +
        	"	if (head == null) return false;\n" +
        	"	if (head.data == n) return true;\n" +
        	"    	return DFS(head.left, n) || DFS(head.right, n);\n" +
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
	);

	private final String questionHtml;

	FirstQuestion(String questionHtml) {
		this.questionHtml = questionHtml;
	}

	public String getQuestionHtml() {
		return questionHtml;
	}
}
