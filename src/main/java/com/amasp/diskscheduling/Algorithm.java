package com.amasp.diskscheduling;

import java.util.ArrayList;

public class Algorithm {

    public static ArrayList<Integer> FCFS(ArrayList<Integer> arr, int head) {
        ArrayList<Integer> sequence = new ArrayList<>(arr);
        int total = 0;
        int prev = head;

        for (int curr : sequence) {
            total += Math.abs(curr - prev);
            prev = curr;
        }
        sequence.add(total);
        return sequence;
    }

    public static ArrayList<Integer> SCAN(ArrayList<Integer> arr, int head, int dir) {
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for (int req : arr) {
            if (req < head) {
                left.add(req);
            } else {
                right.add(req);
            }
        }

        left.sort(null);
        right.sort(null);

        ArrayList<Integer> sequence = new ArrayList<>();

        int total = 0;
        int prev = head;

        if (dir == 0) { // LEFT

            for (int i = left.size() - 1; i >= 0; i--) {
                int curr = left.get(i);
                sequence.add(curr);
                total += Math.abs(prev - curr);
                prev = curr;
            }

            if (prev != 0) {
                sequence.add(0);
                total += Math.abs(prev - 0);
                prev = 0;
            }

            for (int curr : right) {
                sequence.add(curr);
                total += Math.abs(prev - curr);
                prev = curr;
            }

        } else { // RIGHT

            for (int curr : right) {
                sequence.add(curr);
                total += Math.abs(prev - curr);
                prev = curr;
            }

            if (prev != 199) {
                sequence.add(199);
                total += Math.abs(prev - 199);
                prev = 199;
            }

            for (int i = left.size() - 1; i >= 0; i--) {
                int curr = left.get(i);
                sequence.add(curr);
                total += Math.abs(prev - curr);
                prev = curr;
            }
        }

        sequence.add(total);

        return sequence;
    }

    public static ArrayList<Integer> C_SCAN(ArrayList<Integer> arr, int head, int dir) {
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for (int req : arr) {
            if (req < head) {
                left.add(req);
            } else {
                right.add(req);
            }
        }

        left.sort(null);
        right.sort(null);

        ArrayList<Integer> sequence = new ArrayList<>();

        int total = 0;
        int prev = head;

        if (dir == 1) { // RIGHT

            for (int curr : right) {
                sequence.add(curr);
                total += Math.abs(prev - curr);
                prev = curr;
            }

            if (prev != 199) {
                sequence.add(199);
                total += Math.abs(prev - 199);
                prev = 199;
            }

            // wrap
            sequence.add(0);
            total += Math.abs(prev - 0);
            prev = 0;

            for (int curr : left) {
                sequence.add(curr);
                total += Math.abs(prev - curr);
                prev = curr;
            }

        } else { // LEFT

            for (int i = left.size() - 1; i >= 0; i--) {
                int curr = left.get(i);
                sequence.add(curr);
                total += Math.abs(prev - curr);
                prev = curr;
            }

            if (prev != 0) {
                sequence.add(0);
                total += Math.abs(prev - 0);
                prev = 0;
            }

            // wrap
            sequence.add(199);
            total += Math.abs(prev - 199);
            prev = 199;

            for (int i = right.size() - 1; i >= 0; i--) {
                int curr = right.get(i);
                sequence.add(curr);
                total += Math.abs(prev - curr);
                prev = curr;
            }
        }

        sequence.add(total);
        return sequence;
    }

    public static ArrayList<Integer> SSTF(ArrayList<Integer> arr, int head) {
        ArrayList<Integer> requests = new ArrayList<>(arr); // avoid modifying original
        ArrayList<Integer> sequence = new ArrayList<>();

        int total = 0;
        int prev = head;

        while (!requests.isEmpty()) {
            int closest = requests.get(0);
            int minDist = Math.abs(prev - closest);

            for (int req : requests) {
                int dist = Math.abs(prev - req);
                if (dist < minDist) {
                    minDist = dist;
                    closest = req;
                }
            }

            sequence.add(closest);
            total += minDist;
            prev = closest;
            requests.remove(Integer.valueOf(closest));
        }

        sequence.add(total);
        return sequence;
    }

    public static ArrayList<Integer> LOOK(ArrayList<Integer> arr, int head, int dir) {
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for (int req : arr) {
            if (req < head) {
                left.add(req);
            } else {
                right.add(req);
            }
        }

        left.sort(null);
        right.sort(null);

        ArrayList<Integer> sequence = new ArrayList<>();
        int total = 0;
        int prev = head;

        if (dir == 0) { // LEFT

            for (int i = left.size() - 1; i >= 0; i--) {
                int curr = left.get(i);
                sequence.add(curr);
                total += Math.abs(prev - curr);
                prev = curr;
            }

            for (int curr : right) {
                sequence.add(curr);
                total += Math.abs(prev - curr);
                prev = curr;
            }

        } else { // RIGHT

            for (int curr : right) {
                sequence.add(curr);
                total += Math.abs(prev - curr);
                prev = curr;
            }

            for (int i = left.size() - 1; i >= 0; i--) {
                int curr = left.get(i);
                sequence.add(curr);
                total += Math.abs(prev - curr);
                prev = curr;
            }
        }

        sequence.add(total);
        return sequence;
    }

    public static ArrayList<Integer> C_LOOK(ArrayList<Integer> arr, int head, int dir) {
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for (int req : arr) {
            if (req < head) {
                left.add(req);
            } else {
                right.add(req);
            }
        }

        left.sort(null);
        right.sort(null);

        ArrayList<Integer> sequence = new ArrayList<>();
        int total = 0;
        int prev = head;

        if (dir == 1) { // RIGHT

            for (int curr : right) {
                sequence.add(curr);
                total += Math.abs(prev - curr);
                prev = curr;
            }

            if (!left.isEmpty()) {
                // jump to smallest (no service in between)
                int jump = left.get(0);
                total += Math.abs(prev - jump);
                prev = jump;
            }

            for (int curr : left) {
                sequence.add(curr);
                total += Math.abs(prev - curr);
                prev = curr;
            }

        } else { // LEFT

            for (int i = left.size() - 1; i >= 0; i--) {
                int curr = left.get(i);
                sequence.add(curr);
                total += Math.abs(prev - curr);
                prev = curr;
            }

            if (!right.isEmpty()) {
                // jump to largest
                int jump = right.get(right.size() - 1);
                total += Math.abs(prev - jump);
                prev = jump;
            }

            for (int i = right.size() - 1; i >= 0; i--) {
                int curr = right.get(i);
                sequence.add(curr);
                total += Math.abs(prev - curr);
                prev = curr;
            }
        }

        sequence.add(total);
        return sequence;
    }
}
