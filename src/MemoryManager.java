public class MemoryManager {
    private int memoryAccessNumber = 0;
    public void updateMemory(){
        memoryAccessNumber++;
    }
    public double getAvarageMemoryAccess(double nodeNumber){
        return memoryAccessNumber/nodeNumber;
    }

    public int getMemoryAccessNumber() {
        return memoryAccessNumber;
    }

    public void setMemoryAccessNumber(int memoryAccessNumber) {
        this.memoryAccessNumber = memoryAccessNumber;
    }
}
