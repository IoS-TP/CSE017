/***
 * Class to model the instance ServerList
 * CSE 017
 * @author  Matthew Bergin
 * @version 0.1
 * Date of Creation: October 13, 2022
 * Last Date Modified: October 14, 2022
 */
import java.util.ArrayList;
public class ServerList {
    //Data Member
    private ArrayList<Server> list;
    /***
     * Constructor with one parameter
     * @param   servers to hold the amount of servers and size of the ArrayList
     */
    public ServerList(int servers){
        list = new ArrayList<>(servers);
        for(int i =0; i < servers; i++){
            list.add(new Server());
        }
    }
    /***
     * Method to return the index of the first free server
     * @param   no parameters
     * @return  the index of the first free server in the list
     */
    public int getFreeServer(){
        for(int i =0; i < list.size(); i++){
            if (list.get(i).isFree()){
                return i;
            }
        }
        return -1;
    }
    /***
     * Method to set the data members for a newly busy server
     * @param   i for the index of the server
     * @param   c for the new customer they are serving
     * @param   serviceTime for the value of the data member serviceTime
     * no return value
     */
    public void setServerBusy(int i, Customer c, int serviceTime){
        list.get(i).setBusy();
        list.get(i).setServiceTime(serviceTime);
        list.get(i).setCurrentCustomer(c);
    }
    /***
     * Method to update the serviceTimes of the busy servers and set them to free if they finish
     * @param   no parameters
     * no return value
     */
    public void updateServiceTime(){
        for (Server server: list){
            if(!server.isFree()){
                server.decrementServiceTime();
                if (server.getServiceTime()==0){
                    server.setFree();
                }
            }
        }
    }
    /***
     * Method to get the amount of servers in the list that are currently busy
     * @param   no parameters
     * @return  the integer amount of servers that are currently busy
     */
    public int getBusyServers(){
        int cnt=0;
         for (Server server: list){
            if(!server.isFree()){
                cnt++;
            }
         }
         return cnt;
    }
    /***
     * Method to return a formatted String containing the values of the servers in the list
     * @param   no parameters
     * @return  a formatted String containing the values of the servers in the list
     */
    public String toString(){
        String ans = "";
        for (Server server: list){
            ans+= server.toString() + "\n";
        }
        return ans;
    }
}