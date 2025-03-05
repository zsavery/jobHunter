import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zsavery.jobs.Job;
import org.zsavery.jobs.JobLine;
import org.zsavery.jobs.JobTable;

import static org.junit.jupiter.api.Assertions.*;

public class JobTableTest {
    JobLine mcDonald;
    JobLine bucces;
    JobTable table;

    @BeforeEach
    void setUp() {
        mcDonald = new JobLine(new Job("123 Hamburger Lane, Sugar Land, 77083, Texas",
                "McDonald Corp.", 24000, "Line Cook"));
        bucces = new JobLine(new Job("250 3rd St., Sugar Land, 77083, Texas",
                "Buc'ces Inc.", 30000, "Cashier"));

        table = new JobTable();

        table.addJobLine(mcDonald);
        table.addJobLine(bucces);
    }

    @Test
    public void testIfTableExists() {
        assertNotNull(table, "Instance of JobTable is null");
    }

    @Test
    public void testConstructor(){
        assertInstanceOf(JobTable.class, table, "Instance of JobTable is created");

    }

    @Test
    public void testToString(){
        assertEquals("JobListing [job=Job [address=123 Hamburger Lane, Sugar Land, 77083, Texas, company=McDonald Corp., salary=24000.0, position=Line Cook], status=INTERESTED, updated=2025-03-04]",
                table.getJobLine(0).toString(),
                "String output of first row");
        assertEquals("JobListing [job=Job [address=250 3rd St., Sugar Land, 77083, Texas, company=Buc'ces Inc., salary=30000.0, position=Cashier], status=INTERESTED, updated=2025-03-04]",
                table.getJobLine(1).toString(),
                "String output of second row");
        assertEquals("""
                JobTable=[
                \tjobLine=[JobListing [job=Job [address=123 Hamburger Lane, Sugar Land, 77083, Texas, company=McDonald Corp., salary=24000.0, position=Line Cook], status=INTERESTED, updated=2025-03-04]],
                \tjobLine=[JobListing [job=Job [address=250 3rd St., Sugar Land, 77083, Texas, company=Buc'ces Inc., salary=30000.0, position=Cashier], status=INTERESTED, updated=2025-03-04]]
                ]""", table.toString());
    }
}
