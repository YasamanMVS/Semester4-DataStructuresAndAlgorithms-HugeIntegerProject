public class HugeInteger {
    private class Node {
        int digit;
        Node next;
        Node prev;

        // Node Constructor
        public Node(int digit) {
            this.digit = digit;
            this.next = null;
            this.prev = null;
        }
    }
    private boolean isPositive;
    private Node head;
    private Node tail;
    private int length;


    // Constructors:
    public HugeInteger() {
        isPositive = true;
        head = null;
        tail = null;
        length = 0;
    }

    // Taking a huge integer as a string
    public HugeInteger(String num) {
        this();
        // Negative Numbers (start with "-")
        if (num.startsWith("-")) {
            isPositive = false;
            // Remove the "-"
            num = num.substring(1);
        }
        // Remove zeros
        num = num.replaceFirst("^0+(?!$)", "");

        // If its empty or just "-"
        if (num.equals("") || num.equals("-")) {
            head = new Node(0);
            tail = head;
            length = 1;
        } else {
            // Convert it to a digit
            for (int i = num.length() -1; i >= 0; i--) {
                int digit = Character.digit(num.charAt(i), 10);
                if (digit != -1) {
                    // Adding to the linked list
                    if (head == null) {
                        head = new Node(digit);
                        tail = head;
                    } else {
                        tail.next = new Node(digit);
                        tail.next.prev = tail;
                        tail = tail.next;
                    }
                    length ++;
                } else {
                    throw new IllegalArgumentException("Invalid character found!! " + num.charAt(i));
                }
            }
        }
    }
    @Override
    public String toString() {
        // Return "0" if its empty
        if (head == null) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        // Add "-" if its negative
        if (!isPositive) {
            sb.append("-");
        }
        Node current = tail;
        while (current != null) {
            sb.append(current.digit);
            current = current.prev;
        }
        return sb.toString();
    }

    // Adding a digit to the end of the linked list
    private void addLast(int digit) {
        Node newNode = new Node(digit);
        // If the list is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length ++;
    }

    // Adding two positive HugeInteger, and their sum
    public HugeInteger addPositive(HugeInteger num2) {
        HugeInteger result = new HugeInteger();
        Node currentThis = this.head;
        Node currentNum2 = num2.head;
        int carry = 0;

        while (currentThis != null || currentNum2 != null || carry != 0) {
            int sum = carry;
            if (currentThis != null) {
                sum += currentThis.digit;
                currentThis = currentThis.next;
            }
            if (currentNum2 != null) {
                sum += currentNum2.digit;
                currentNum2 = currentNum2.next;
            }
            result.addLast(sum % 10);
            carry = sum / 10;
        }
        result.isPositive = true;
        return result;
    }

    // Compare two HugeInteger
    public int compareTo(HugeInteger num2) {
        // Checking numbers signs
        if (this.isPositive && !num2.isPositive) return 1;
        if (!this.isPositive && num2.isPositive) return -1;

        // If same sign, compare lengths
        if (this.length > num2.length) return this.isPositive ? 1 : -1;
        if (this.length < num2.length) return this.isPositive ? -1 : 1;

        // If same length, compare digit by digit
        Node thisCurrent = this.tail;
        Node num2Current = num2.tail;
        while (thisCurrent != null && num2Current != null) {
            if (thisCurrent.digit > num2Current.digit) return this.isPositive ? 1 : -1;
            if (thisCurrent.digit < num2Current.digit) return this.isPositive ? -1 : 1;
            thisCurrent = thisCurrent.prev;
            num2Current = num2Current.prev;
        }
        // If all digits are same, so they are equal
        return 0;
    }

    // Adding a digit to the front of the linked list
    public void concatenateDigit(int digit) {
        Node newNode = new Node(digit);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        if (digit != 0 || length == 0) {
            length ++;
        }
    }
}
