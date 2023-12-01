import java.util.*;

class Main {
    static class Patient {
        String id;
        int age;

        public Patient(String id, int age) {
            this.id = id;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 病人个数
        List<Patient> patients = new ArrayList<>();

        // 输入病人信息
        for (int i = 0; i < n; i++) {
            String id = scanner.next();
            int age = scanner.nextInt();
            patients.add(new Patient(id, age));
        }

        // 按照规则排序病人
        patients.sort((p1, p2) -> {
            if (p1.age >= 60 && p2.age < 60) {
                return -1;
            } else if (p1.age < 60 && p2.age >= 60) {
                return 1;
            } else if (p1.age >= 60 && p2.age >= 60) {
                return Integer.compare(p2.age, p1.age);
            } else {
                return 0;
            }
        });

        // 输出病人编号
        for (Patient patient : patients) {
            System.out.println(patient.id);
        }
    }
}
