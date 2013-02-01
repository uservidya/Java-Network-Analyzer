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
import java.io.FileNotFoundException;
import java.util.HashMap;
import org.junit.Test;

/**
 * Tests graph analysis on weighted bidirectional graphs.
 *
 * @author Adam Gouge
 */
// TODO: Make up a better example where contraction hierarchies are actually used.
public class WeightedBidirectionalGraphAnalyzerTest extends WeightedGraphAnalyzerTest {

    /**
     * Tests graph analysis on a 2D weighted bidirectional graph.
     *
     * @throws FileNotFoundException
     */
    @Test
    public void test2DGraph() throws FileNotFoundException {

        printTitle(Graphs.GRAPH2D);

        // Prepare the graph.
        GDMSGraphStorage graph = Graphs.graph2DWeightedBidirectional();

        // Prepare the unweighted graph analyzer.
        WeightedGraphAnalyzer analyzer =
                new WeightedGraphAnalyzer(graph);

        // Do analysis.
        HashMap<Integer, NodeBetweennessInfo> results = analyzer.computeAll();
        printResults(results);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getName() {
        return Graphs.WEIGHTED + " " + Graphs.BIDIRECTIONAL;
    }
}
