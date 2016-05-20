package msi.gama.outputs.layers.charts;

import java.awt.Color;
import java.awt.Font;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import msi.gama.common.interfaces.IKeyword;
import msi.gama.outputs.layers.charts.ChartJFreeChartOutputScatter.myXYErrorRenderer;
import msi.gama.runtime.IScope;
import msi.gaml.expressions.IExpression;
import msi.gaml.operators.Cast;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.AbstractRenderer;
import org.jfree.chart.renderer.xy.XYErrorRenderer;
import org.jfree.data.general.Dataset;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.ui.RectangleInsets;

public class ChartJFreeChartOutput extends ChartOutput {

	
	public static final Shape[] defaultmarkers = org.jfree.chart.plot.DefaultDrawingSupplier
			.createStandardSeriesShapes();

	
	 public ChartRenderingInfo info;
	 ArrayList<Dataset> jfreedataset=new ArrayList<Dataset>();
	 JFreeChart chart = null;
	 AbstractRenderer defaultrenderer;
	 HashMap<String,Integer> IdPosition=new HashMap<String,Integer>(); //serie id-nb for arraylists/table requirements
	 HashMap<String,AbstractRenderer> RendererSet=new HashMap<String,AbstractRenderer>(); //one renderer for each serie
	 int nbseries=0; // because there is always one dataset, so it is difficult to count...
	 
		public ChartJFreeChartOutput(final IScope scope,String name,IExpression typeexp)
		{
			super(scope, name,typeexp);
			info = new ChartRenderingInfo();
		}
	 
	 
	public static ChartJFreeChartOutput createChartOutput(final IScope scope,String name,IExpression typeexp)
	{
		ChartJFreeChartOutput newChart;
		int type=SERIES_CHART;

		IExpression string1 = typeexp;
		if ( string1 != null ) {
			String t = Cast.asString(scope, string1.value(scope));
			type =
					IKeyword.SERIES.equals(t) ? SERIES_CHART : IKeyword.HISTOGRAM.equals(t) ? HISTOGRAM_CHART
							: IKeyword.PIE.equals(t) ? PIE_CHART 
									: IKeyword.RADAR.equals(t) ? RADAR_CHART 
									: IKeyword.HEATMAP.equals(t) ? HEATMAP_CHART 
									: IKeyword.BOX_WHISKER.equals(t) ? BOX_WHISKER_CHART
									: IKeyword.SCATTER.equals(t) ? SCATTER_CHART : XY_CHART;

		}
		

		switch (type) {
		case SERIES_CHART: {
			newChart = new ChartJFreeChartOutputScatter(scope,name,typeexp);
			break;
		}
		case PIE_CHART: {
			newChart = new ChartJFreeChartOutputPie(scope,name,typeexp);
			break;
		}
		case HISTOGRAM_CHART: {
			newChart = new ChartJFreeChartOutputHistogram(scope,name,typeexp);
			break;
		}
		case XY_CHART:
			newChart = new ChartJFreeChartOutputScatter(scope,name,typeexp);
			break;
		case SCATTER_CHART:
			newChart = new ChartJFreeChartOutputScatter(scope,name,typeexp);
			break;
		case BOX_WHISKER_CHART: {
			newChart = new ChartJFreeChartOutputHistogram(scope,name,typeexp);
			break;
		}
		case RADAR_CHART: {
			newChart = new ChartJFreeChartOutputRadar(scope,name,typeexp);
			break;
		}
		case HEATMAP_CHART: {
			newChart = new ChartJFreeChartOutputHeatmap(scope,name,typeexp);
			break;
		}
		default:
		{
			newChart = new ChartJFreeChartOutputScatter(scope,name,typeexp);			
		}
		}
		return newChart;
	}

	

	public BufferedImage getImage(IScope scope, int sizex, int sizey)
	{
		getJFChart().setAntiAlias(true);
		getJFChart().setTextAntiAlias(true);

		updateOutput(scope);
		BufferedImage buf=chart.createBufferedImage(sizex, sizey,info);
		System.out.println(info);
		return buf;
	}
	
	protected void initRenderer(IScope scope) {
		// TODO Auto-generated method stub
		
	}
	
	public void initChart(IScope scope, String chartname)
	{
		super.initChart(scope,chartname);
		
		initRenderer(scope);
		Plot plot = chart.getPlot();

		chart.setTitle(this.getName());
		chart.getTitle().setVisible(true);
		chart.getTitle().setFont(getTitleFont());
		if (textColor!=null)
		{
			chart.getTitle().setPaint(textColor);				
		}

		if ( backgroundColor == null ) {
			plot.setBackgroundPaint(null);
			chart.setBackgroundPaint(null);
			chart.setBorderPaint(null);
			if ( chart.getLegend() != null ) {
				chart.getLegend().setBackgroundPaint(null);
			}
		} else {
			Color bg = backgroundColor;
			chart.setBackgroundPaint(bg);
			plot.setBackgroundPaint(bg);
			chart.setBorderPaint(bg);
			if ( chart.getLegend() != null ) {
				chart.getLegend().setBackgroundPaint(bg);
			}
		}
		if ( chart.getLegend() != null ) {
			chart.getLegend().setItemFont(getLegendFont());
			if (textColor!=null)
			{
				chart.getLegend().setItemPaint(textColor);				
			}
		}
		
		
    	

	}
	
	AbstractRenderer getOrCreateRenderer(IScope scope, String serieid)
	{
		if (RendererSet.containsKey(serieid))
		{
			return RendererSet.get(serieid);
		}
		else
		{
			AbstractRenderer newrenderer=createRenderer(scope,serieid);
			RendererSet.put(serieid, newrenderer);
			return newrenderer;
		}
		
	}


	
	protected AbstractRenderer createRenderer(IScope scope,String serieid) {
		// TODO Auto-generated method stub
		return new XYErrorRenderer();
		
	}


	Font getLabelFont() {
		return new Font(labelFontFace, labelFontStyle, labelFontSize);
	}

	Font getTickFont() {
		return new Font(tickFontFace, tickFontStyle, tickFontSize);
	}

	Font getLegendFont() {
		return new Font(legendFontFace, legendFontStyle, legendFontSize);
	}

	Font getTitleFont() {
		return new Font(titleFontFace, titleFontStyle, titleFontSize);
	}	
	
	protected void updateImage(IScope scope) {
		// TODO Auto-generated method stub
	}

	public JFreeChart getJFChart()
	{
		return chart;
	}
	
	
	
}
