function mostrarTopologiaRed(){
	var idRed = $("#net-select").val();
	var container = $('#net-container')[0];
	if (idRed != -1){
		
		$.ajax({url: "/TMNIntegralWeb/displayNetworkGraph.htm?netId=" + idRed, success: function(result){
			// provide data in the DOT language
			var DOTstring = 'dinetwork {' + result + '}';
			var parsedData = vis.network.convertDot(DOTstring);
			
			var data = {
					nodes: parsedData.nodes,
					edges: parsedData.edges
			}
			
			var options = parsedData.options;
			
			// you can extend the options like a normal JSON variable:
			options.nodes = {
					color: 'red'
			}
			
			// create a network
			var network = new vis.Network(container, data, options);
	    }});
	}else{
		alert('Debe seleccionar una red para visualizar.');
	}
}

function mostrarTopologiaConImagenes(idRed) {
    var DIR = window.location.pathname +  '/../images/topologia/';
    var EDGE_LENGTH_MAIN = 150;
    var EDGE_LENGTH_SUB = 50;

	// Create a data table with nodes.
    nodes = [];

    // Create a data table with links.
    edges = [];

    nodes.push({id: 1, label: 'Main', image: DIR + 'router.png', shape: 'image'});
    nodes.push({id: 2, label: 'Office', image: DIR + 'router.png', shape: 'image'});
    nodes.push({id: 3, label: 'Wireless', image: DIR + 'router.png', shape: 'image'});
    edges.push({from: 1, to: 2, length: EDGE_LENGTH_MAIN});
    edges.push({from: 1, to: 3, length: EDGE_LENGTH_MAIN});

    for (var i = 4; i <= 7; i++) {
      nodes.push({id: i, label: 'Computer', image: DIR + 'computer.png', shape: 'image'});
      edges.push({from: 2, to: i, length: EDGE_LENGTH_SUB});
    }

    nodes.push({id: 101, label: 'Printer', image: DIR + 'printer.png', shape: 'image'});
    edges.push({from: 2, to: 101, length: EDGE_LENGTH_SUB});

    nodes.push({id: 102, label: 'Laptop', image: DIR + 'computer.png', shape: 'image'});
    edges.push({from: 3, to: 102, length: EDGE_LENGTH_SUB});

    nodes.push({id: 104, label: 'Internet', image: DIR + 'internet.png', shape: 'image'});
    edges.push({from: 1, to: 104, length: EDGE_LENGTH_SUB});

    // create a network
    var container = document.getElementById('net-container');
    var data = {
      nodes: nodes,
      edges: edges
    };
    var options = {};
    network = new vis.Network(container, data, options);
  }