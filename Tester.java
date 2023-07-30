import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;  

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("short-test_log");
        logAnalyzer.printAll();
    }
    
    public void testUniqIP () {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("weblog2_log");
        int uniqueIPs = logAnalyzer.countUniqueIPs();
        System.out.println("There are " + uniqueIPs + " unique IPs");
    }
    
    public void testAllHigherThanNum () {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("weblog1_log");
        int num = 400;
        logAnalyzer.printAllHigherThanNum(num);
    }
    
    public void testUniqIPsOnDay () {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("weblog2_log");
        String someday = "Sep 27";
        ArrayList<String> uniqueIPsOnDay = logAnalyzer.uniqueIPVisitsOnDay(someday);
        System.out.println("There are " + uniqueIPsOnDay.size() + " unique IPs on day " + someday);
    }
    
    public void testUniqueIPsInRange () {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("weblog2_log");
        int low = 400;
        int high = 499;
        int uniqueIPsInRange = logAnalyzer.countUniqueIPsInRange(low, high);
        System.out.println("There are " + uniqueIPsInRange + " unique IPs with Status Code in range " + low + " - " + high);
    }
    
    public void testCountVisitsPerIp () {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("weblog1_log");
        HashMap<String, Integer> counts = logAnalyzer.countVisitsPerIP();
        for (String ip : counts.keySet()) {
            System.out.println("IP: " + ip + " visited: " + counts.get(ip) + " number of times");
        }
    }
    
    public void testMostNumberVisitsByIP () {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("weblog2_log");
        HashMap<String, Integer> counts = logAnalyzer.countVisitsPerIP();
        int maxVisits = logAnalyzer.mostNumberVisitsByIP(counts);
        System.out.println("Most number of visits per IP: " + maxVisits);
    }
    
    public void testIPsMostVisits () {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("weblog2_log");
        ArrayList<String> IPsList = logAnalyzer.iPsMostVisits(logAnalyzer.countVisitsPerIP());
        for (String ip : IPsList) {
            System.out.println("IP: " + ip);
        }
    }
    
    public void testIPsForDays () {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("weblog1_log");
        HashMap<String, ArrayList<String>> iPsDays = logAnalyzer.iPsForDays();
        for (String day : iPsDays.keySet()) {
            System.out.println("On day " + day + " visited by IPs: " + iPsDays.get(day));
        }
    }
    
    public void testDayWithMostIPVisits () {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("weblog2_log");
        HashMap<String, ArrayList<String>> iPsDays = logAnalyzer.iPsForDays();
        String maxDay = logAnalyzer.dayWithMostIPVisits(iPsDays);
        System.out.println("Most visits on day " + maxDay);
    }
    
    public void testIPsWithMostVisitsOnDay () {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("weblog2_log");
        HashMap<String, ArrayList<String>> iPsDays = logAnalyzer.iPsForDays();
        String day = "Sep 29";
        ArrayList<String> iPsWithMostVisitsOnOneDay = logAnalyzer.iPsWithMostVisitsOnDay(iPsDays, day);
        System.out.println("IPs with most visits on day " + day);
        for (String ip : iPsWithMostVisitsOnOneDay) {
            System.out.println("IP: " + ip);
        }
    }
}
