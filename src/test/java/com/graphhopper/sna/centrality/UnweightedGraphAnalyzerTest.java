/**
 * GraphHopper-SNA implements a collection of social network analysis
 * algorithms. It is based on the <a
 * href="http://graphhopper.com/">GraphHopper</a> library.
 *
 * GraphHopper-SNA is distributed under the GPL 3 license. It is produced by the
 * "Atelier SIG" team of the <a href="http://www.irstv.fr">IRSTV Institute</a>,
 * CNRS FR 2488.
 *
 * Copyright 2012 IRSTV (CNRS FR 2488)
 *
 * GraphHopper-SNA is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * GraphHopper-SNA is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * GraphHopper-SNA. If not, see <http://www.gnu.org/licenses/>.
 */
package com.graphhopper.sna.centrality;

import com.graphhopper.sna.data.NodeBetweennessInfo;
import com.graphhopper.sna.storage.GDMSGraphStorage;
import gnu.trove.map.hash.TIntDoubleHashMap;
import java.io.FileNotFoundException;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Tests graph analysis on unweighted graphs.
 *
 * @author Adam Gouge
 */
public class UnweightedGraphAnalyzerTest extends GraphSetupTest {

    /**
     * Tests graph analysis on a 2D unweighted bidirectional graph.
     *
     * @throws FileNotFoundException
     */
    // TODO: Write a similar test for directed graphs.
    @Test
    public void testUnweightedGraphAnalysis2DBidirectional() throws
            FileNotFoundException {

        System.out.println("\n***** UNWEIGHTED 2D BIDIRECTIONAL *****");

        // Prepare the graph.
        GDMSGraphStorage graph = prepareGraph2DBidirectional();

        // Prepare the unweighted graph analyzer.
        UnweightedGraphAnalyzer analyzer =
                new UnweightedGraphAnalyzer(graph);

        // Calculate betweenness.
        long start = System.currentTimeMillis();
        HashMap<Integer, NodeBetweennessInfo> result = analyzer.computeAll();
        long stop = System.currentTimeMillis();
        System.out.println("Network analysis took " + (stop - start)
                + " ms to compute.");

        checkResults2DBidirectional(result);
        printResults(result);
    }

    /**
     * Checks the computations for the 2D bidirectional graph.
     *
     * @param result Result to check.
     */
    private void checkResults2DBidirectional(
            HashMap<Integer, NodeBetweennessInfo> result) {
        assertEquals(result.get(6).getCloseness(),
                     0.625, TOLERANCE);
        assertEquals(result.get(5).getCloseness(),
                     0.4166666666666667, TOLERANCE);
        assertEquals(result.get(4).getCloseness(),
                     0.35714285714285715, TOLERANCE);
        assertEquals(result.get(3).getCloseness(),
                     0.625, TOLERANCE);
        assertEquals(result.get(2).getCloseness(),
                     0.4166666666666667, TOLERANCE);
        assertEquals(result.get(1).getCloseness(),
                     0.5, TOLERANCE);
        assertEquals(result.get(6).getBetweenness(),
                     0.45, TOLERANCE);
        assertEquals(result.get(5).getBetweenness(),
                     0.0, TOLERANCE);
        assertEquals(result.get(4).getBetweenness(),
                     0.0, TOLERANCE);
        assertEquals(result.get(3).getBetweenness(),
                     0.6, TOLERANCE);
        assertEquals(result.get(2).getBetweenness(),
                     0.0, TOLERANCE);
        assertEquals(result.get(1).getBetweenness(),
                     0.3, TOLERANCE);
    }
}
