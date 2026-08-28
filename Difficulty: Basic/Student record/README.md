<h2><a href="https://www.geeksforgeeks.org/problems/student-record1752/1">Student record</a></h2><h3>Difficulty Level : Difficulty: Basic</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p class="PDq2pG_selectionAnchorContainer" data-start="206" data-end="373"><span style="font-size: 18.6667px;">Given a string array <strong>names[]</strong> containing the names of n students and a 2D integer array <strong>marks[][]</strong>, where marks[i] contains the marks of the i-th student in three subjects, find the student or students having the maximum average score.</span></p>
<p class="PDq2pG_selectionAnchorContainer" data-start="206" data-end="373"><span style="font-size: 18.6667px;">The i-th element of names corresponds to the i-th row of marks.</span></p>
<p class="PDq2pG_selectionAnchorContainer" data-start="206" data-end="373"><span style="font-size: 18.6667px;">The division is performed using integer division, so the average is rounded down.</span></p>
<p class="PDq2pG_selectionAnchorContainer" data-start="206" data-end="373"><span style="font-size: 18.6667px;">If multiple students have the same maximum average, include all their names in the same order as they appear in names.</span></p>
<p class="PDq2pG_selectionAnchorContainer" data-start="206" data-end="373"><span style="font-size: 18.6667px;">Return a string containing the names of all students with the maximum average, followed by the maximum average.</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong> names[] = ["Shrikanth", "Ram"], marks[][] = [[20, 30, 10], [100, 50, 10]]
<strong>Output:</strong> Ram 53
<strong>Explanation: </strong>Shrikanth has an average of (20 + 30 + 10) / 3 = 20, whereas Ram has an average of (100 + 50 + 10) / 3 = 53.
Therefore, Ram has the maximum average.</span></pre>
<pre><span style="font-size: 18px;"><strong>Input:</strong> names[] = ["Adam", "Rocky", "Suresh"], marks[][] = [[50, 10, 40], [100, 90, 10], [10, 90, 100]]
<strong>Output:</strong> Rocky Suresh 66
<strong>Explanation: </strong>Rocky has an average of (100 + 90 + 10) / 3 = 66, and Suresh has an average of (10 + 90 + 100) / 3 = 66.
Both have the maximum average, so their names are returned in the same order as they appear in names[].</span></pre></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Amazon</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Mathematics</code>&nbsp;