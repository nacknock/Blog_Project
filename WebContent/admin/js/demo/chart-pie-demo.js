// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

// Pie Chart Example
var ctx = document.getElementById("myPieChart");
var myPieChart = new Chart(ctx, {
  type: 'doughnut',
  data: {
    labels: ["Direct", "Referral", "Social"],
    datasets: [{
      data: [55, 30, 15],
      backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc'],
      hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
      hoverBorderColor: "rgba(234, 236, 244, 1)",
    }],
  },
  options: {
    maintainAspectRatio: false,
    tooltips: {
      backgroundColor: "rgb(255,255,255)",
      bodyFontColor: "#858796",
      borderColor: '#dddfeb',
      borderWidth: 1,
      xPadding: 15,
      yPadding: 15,
      displayColors: false,
      caretPadding: 10,
    },
    legend: {
      display: false
    },
    cutoutPercentage: 80,
  },
});

function updateChartPie(period) {
  const chartPie_small = document.getElementById('chartPie-small');
  if (period === '1년') {
    // 1년 데이터
    myPieChart.data.datasets[0].data = [55, 15, 15, 15];
    myPieChart.data.labels = ["요리", "스포츠", "영화","그 외"];
    chartPie_small.textContent = "(기준:1년)";
  } else if (period === '1달') {
      // 1달 데이터 예시
    myPieChart.data.datasets[0].data = [35, 30, 15, 20];
    myPieChart.data.labels = ["만화", "게임", "요리","그 외"];
      chartPie_small.textContent = "(기준:1달)";
  } else if (period === '1일') {
      // 1일 데이터 예시
    myPieChart.data.datasets[0].data = [25, 30, 15, 20, 15];
    myPieChart.data.labels = ["스포츠", "여행", "맛집","그 외"];
      chartPie_small.textContent = "(기준:1일)";
  }
  
  
    myPieChart.update(); // 차트를 업데이트합니다.
}
