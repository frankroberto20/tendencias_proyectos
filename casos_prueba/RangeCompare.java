public class RangeCompare{
    public static void main(String[] args){
        //Range range1 = new Range("hola");
        Range range1 = new Range("(4, 8]");
        System.out.println(range1.equals("9999"));
    }

    static class Range{
        int[] values;
        int startPoint;
        int endPoint;

        public Range(int ...valueSet){
            startPoint = Integer.MAX_VALUE;
            endPoint = Integer.MIN_VALUE;
            this.values = new int[valueSet.length];
            this.endPoint = getEndPoint(valueSet);
            this.startPoint = getStartPoint(valueSet);
            int position = 0;
            for (int i: valueSet){
                values[position] = i;
                position++;
            }
        }

        public Range(String valueRange){
            this.startPoint = getStartPoint(valueRange);
            this.endPoint = getEndPoint(valueRange);
            this.values = new int[this.endPoint - this.startPoint + 1];
            int position = 0;
            for(int i = this.startPoint; i <= this.endPoint; i++){
                this.values[position] = i;
                position++;
            }
        }

        public boolean contains(int ...valueSet){
            for (int i : valueSet){
                if (i > this.endPoint || i < this.startPoint){
                    return false;
                }
            }
            return true;
        }

        public boolean containsRange(String valueRange){
            int start = getStartPoint(valueRange);
            int end = getEndPoint(valueRange);

            if(end > this.endPoint || start < this.startPoint){
                return false;
            }

            return true;
        }

        public void getAllPoints(){
            System.out.print("{");
            for(int i = 0; i < (this.values.length - 1); i++){
                System.out.print(this.values[i] + ", ");
            }
            System.out.print(this.values[this.values.length - 1] + "}");
        }

        public void getEndPoints(){
            System.out.println("{" + this.startPoint + ", " + this.endPoint + "}");
        }

        public boolean overlapsRange(String valueRange){
            int start = getStartPoint(valueRange);
            int end = getEndPoint(valueRange);
            if (start <= this.startPoint && end >= this.endPoint){
                return true;
            }
            else{
                for(int i = start; i <= end; i++){
                    for(int j : this.values){
                        if (i == j){
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public boolean equals(String valueRange){
            int start = getStartPoint(valueRange);
            int end = getEndPoint(valueRange);
            if (start == this.startPoint && end == this.endPoint && (end - start + 1) == this.values.length){
                return true;
            }
            return false;
        }

        public boolean equals(int ...valueSet){
            int start = getStartPoint(valueSet);
            int end = getEndPoint(valueSet);
            if (start == this.startPoint && end == this.endPoint && (end - start + 1) == this.values.length){
                return true;
            }
            return false;
        }

        private int getEndPoint(String valueRange){
            valueRange = valueRange.replace(" ", "");
            String[] points = valueRange.split(",");
            String end = points[1];
            int endPoint = 0;

            if(end.substring(end.length() - 1, end.length()).equals("]")){
                endPoint = Integer.parseInt(String.valueOf(end.substring(0, end.length() - 1)));
            }
            else if(end.substring(end.length() - 1, end.length()).equals(")")){
                endPoint = Integer.parseInt(String.valueOf(end.substring(0, end.length() - 1))) - 1;
            }

            return endPoint;
        }

        private int getStartPoint(String valueRange){
            valueRange = valueRange.replace(" ", "");
            String[] points = valueRange.split(",");
            String start = points[0];
            int startPoint = 0;

            if(start.substring(0, 1).equals("[")){
                startPoint = Integer.parseInt(String.valueOf(start.substring(1)));
            }
            else if(start.substring(0, 1).equals("(")){
                startPoint = Integer.parseInt(String.valueOf(start.substring(1))) + 1;
            }

            return startPoint;
        }

        private int getStartPoint(int ...valueSet){
            int start = Integer.MAX_VALUE;
            for(int i : valueSet){
                if (i < start){
                    start = i;
                }
            }
            return start;
        }

        private int getEndPoint(int ...valueSet){
            int end = Integer.MIN_VALUE;
            for(int i : valueSet){
                if (i > end){
                    end = i;
                }
            }
            return end;
        }
    }
}
