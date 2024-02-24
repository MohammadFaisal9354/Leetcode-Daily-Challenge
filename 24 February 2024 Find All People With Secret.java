class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        HashSet<Integer> agents = new HashSet();
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] <= o2[2]) {
                    return -1;
                }
                return 1;
            }
        });
        agents.add(0);
        agents.add(firstPerson);
        int ts = -1;
        List<Integer> candidates = new ArrayList();
        boolean converged = false;
        for (int i = 0; i < meetings.length; i++) {
            boolean connected = false;
            while (i < meetings.length && meetings[i][2] == ts) {
                candidates.add(meetings[i][0]);
                candidates.add(meetings[i][1]);
                i++;
            }
            converged = false;
            while (!converged) {
                converged = true;
                for (int k = 0; k < candidates.size(); k += 2) {
                    int oldSize = agents.size();
                    if (agents.contains(candidates.get(k)) || agents.contains(candidates.get(k + 1))) {
                        agents.add(candidates.get(k));
                        agents.add(candidates.get(k + 1));
                    }
                    if (agents.size() > oldSize) {
                        converged = false;
                    }
                }
            }
            candidates.clear();            
            if (i >= meetings.length) 
                break;
            if (agents.contains(meetings[i][0]) || agents.contains(meetings[i][1])) {
                agents.add(meetings[i][0]);
                agents.add(meetings[i][1]);
            } else {
                candidates.add(meetings[i][0]);
                candidates.add(meetings[i][1]);
                ts = meetings[i][2];
            }
        }
        return new ArrayList<Integer>(agents);
    }
}
